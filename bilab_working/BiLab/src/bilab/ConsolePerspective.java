/**
* This document is a part of the source code and related artifacts for BiLab, an open source interactive workbench for 
* computational biologists.
*
* http://computing.ornl.gov/
*
* Copyright © 2011 Oak Ridge National Laboratory
*
* This program is free software; you can redistribute it and/or modify it under the terms of the GNU Lesser General 
* Public License as published by the Free Software Foundation; either version 3 of the License, or (at your option) any 
* later version.
*
* This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied 
* warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License for more 
* details.
*
* You should have received a copy of the GNU Lesser General Public License along with this program; if not, write to 
* the Free Software Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*
* The license is also available at: http://www.gnu.org/copyleft/lgpl.html
*/

package bilab;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IFolderLayout;
import org.eclipse.ui.IViewLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class ConsolePerspective implements IPerspectiveFactory {

	public void createInitialLayout(IPageLayout page) {
		
		page.setEditorAreaVisible(false);
		
		String editorArea = page.getEditorArea();
		
		IFolderLayout folder = page.createFolder("bilab.MainView", IPageLayout.BOTTOM, 1.0f, editorArea);
		
		folder.addView("bilab.ConsoleView");
		IViewLayout consoleView = page.getViewLayout("bilab.ConsoleView");
		consoleView.setCloseable(false);
		
		folder.addView("bilab.BrowserView");
		
		//folder.addView("bilab.TextView");
		
		// then environment navigator view 
		page.addView("bilab.EnvNavigatorView", IPageLayout.RIGHT, 0.7f, "bilab.ConsoleView");
		IViewLayout navView = page.getViewLayout("bilab.EnvNavigatorView");
		navView.setCloseable(false);
		
		// the value viewer
		page.addView("bilab.ValueView", IPageLayout.BOTTOM, 0.5f, "bilab.EnvNavigatorView");
		IViewLayout valueView = page.getViewLayout("bilab.ValueView");
		valueView.setCloseable(false);
	}
}