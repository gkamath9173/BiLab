/* ActionController.java
 *
 * created: Tue Sep 17 2002
 *
 * This file is part of Artemis
 *
 * Copyright (C) 2002  Genome Research Limited
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * $Header: /cvsroot/pathsoft/artemis/uk/ac/sanger/artemis/ActionController.java,v 1.1 2004/06/09 09:44:04 tjc Exp $
 */

package uk.ac.sanger.artemis;

import uk.ac.sanger.artemis.sequence.*;

import uk.ac.sanger.artemis.util.*;
import uk.ac.sanger.artemis.io.OutOfDateException;
import uk.ac.sanger.artemis.io.EntryInformationException;


/**
 *  This class is maintains a Vector of Action objects to allow Undo.
 *
 *  @author Kim Rutherford <kmr@sanger.ac.uk>
 *  @version $Id: ActionController.java,v 1.1 2004/06/09 09:44:04 tjc Exp $
 **/

public class ActionController
    implements EntryGroupChangeListener, EntryChangeListener,
               FeatureChangeListener, SequenceChangeListener {

  /**
   *  Note the start of an action.  Create a new Action and add all
   *  ChangeEvents to it until the next call to endAction().
   **/
  public void startAction () {
    if (Options.getOptions ().getUndoLevels () == 0) {
      // undo disabled
      return;
    }

    if (current_action == null) {
      current_action = new Action ();
    } else {
      current_action = null;
      throw new Error ("internal error - ActionController.startAction() " +
                       "called twice");
    }
  }

  /**
   *  Finish an Action and make a note of the completed Action.
   **/
  public void endAction () {
    if (Options.getOptions ().getUndoLevels () == 0) {
      // undo disabled
      return;
    }

    if (current_action == null) {
      throw new Error ("internal error - in ActionController.endAction() " +
                       "no Action in progress");
    } else {
      if (!current_action.isEmpty ()) {
        action_vector.add (current_action);
      }
      current_action = null;
    }
  }

  /**
   *  Discard all undo information.
   **/
  private void discardUndo () {
    action_vector = new ActionVector ();
  }

  /**
   *  Return true if and only if we can can undo() successfully at least once.
   **/
  public boolean canUndo () {
    if (action_vector.size () == 0) {
      return false;
    } else {
      return true;
    }
  }

  /**
   *  Undo the last Action then return true.  If there was no last Action
   *  return false.
   **/
  public boolean undo () {
    if (action_vector.size () == 0) {
      return false;
    } else {
      final Action temp_current_action = current_action;

      // discard the in-progress Action (if any) and throw an eception below
      current_action = null;

      try {
        final Action last_action = action_vector.removeAndReturnLast ();

        if (last_action.isEmpty ()) {
          return false;
        }

        final ChangeEventVector last_action_change_events =
          last_action.getChangeEvents ();

        for (int i = last_action_change_events.size () - 1 ; i >= 0 ; --i) {
          final ChangeEvent this_event =
            last_action_change_events.elementAt (i);

          if (this_event instanceof FeatureChangeEvent) {
            undoFeatureChange ((FeatureChangeEvent) this_event);
          } else {
            if (this_event instanceof EntryChangeEvent) {
              undoEntryChange ((EntryChangeEvent) this_event);
            } else {
              throw new Error ("internal error - unknown event type: " +
                               this_event);
            }
          }
        }

        if (temp_current_action != null) {
          // throw exception after undo so that undo still works.
          throw new Error ("internal error - in ActionController.undo() " +
                           "Action in progress");
        }

        return true;
      } catch (ArrayIndexOutOfBoundsException e) {
        throw new Error ("internal error - unexpected exception: " + e);
      }
    }
  }

  /**
   *  Undo the effect of one FeatureChangeEvent.
   **/
  private void undoFeatureChange (final FeatureChangeEvent event) {
    final Feature feature = event.getFeature ();

    try {
      if (feature.getEntry () != null) {
        feature.set (null,
                     event.getOldKey (),
                     event.getOldLocation (),
                     event.getOldQualifiers ());
      }
    } catch (OutOfRangeException e) {
      throw new Error ("internal error - unexpected exception: " + e);
    } catch (OutOfDateException e) {
      throw new Error ("internal error - unexpected exception: " + e);
    } catch (ReadOnlyException e) {
      throw new Error ("internal error - unexpected exception: " + e);
    } catch (EntryInformationException e) {
      throw new Error ("internal error - unexpected exception: " + e);
    }
  }

  /**
   *  Undo the effect of one EntryChangeEvent.
   **/
  private void undoEntryChange (final EntryChangeEvent event) {
    try {
      if (event.getType () == EntryChangeEvent.FEATURE_DELETED) {
        event.getEntry ().add (event.getFeature (), true);
      } else {
        if (event.getType () == EntryChangeEvent.FEATURE_ADDED) {
          event.getFeature ().removeFromEntry ();
        }
      }
    } catch (ReadOnlyException e) {
      throw new Error ("internal error - unexpected exception: " + e);
    } catch (EntryInformationException e) {
      throw new Error ("internal error - unexpected exception: " + e);
    } catch (OutOfRangeException e) {
      throw new Error ("internal error - unexpected exception: " + e);
    }
  }

  /**
   *  Implementation of the EntryGroupChangeListener interface.  We listen to
   *  EntryGroupChange events so that we can update the display if entries
   *  are added or deleted.
   **/
  public void entryGroupChanged (final EntryGroupChangeEvent event) {
    switch (event.getType ()) {
    case EntryGroupChangeEvent.ENTRY_DELETED:
      discardUndo ();
      break;
    }
  }
    
  /**
   *  Implementation of the EntryChangeListener interface.  We listen for
   *  FEATURE_ADDED and FEATURE_DELETED events so that we can undo them
   **/
  public void entryChanged (final EntryChangeEvent event) {
    if (current_action != null) {
      current_action.addChangeEvent (event);
    }
  }

  /**
   *  Implementation of the FeatureChangeListener interface.  We need to
   *  listen to feature change events from the Features in this object.
   *  @param event The change event.
   **/
  public void featureChanged (FeatureChangeEvent event) {
    if (current_action != null) {
      current_action.addChangeEvent (event);
    }
  }

  /**
   *  If the sequence changes all bets are off - discard all Actions.
   **/
  public void sequenceChanged (final SequenceChangeEvent event) {
    discardUndo ();
  }

  /**
   *  The current Action.  If null we aren't currently in an Action, if
   *  non-null we are in an Action.
   **/
  private Action current_action = null;

  /**
   *  Storage for Actions.
   **/
  private ActionVector action_vector = new ActionVector ();
}
