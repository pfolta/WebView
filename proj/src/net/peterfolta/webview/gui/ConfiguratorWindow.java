/*
 * WebView - A desktop-like web browsing experience
 * Copyright (C) 2014-2015 Peter Folta. All rights reserved.
 * 
 * Project:			WebView 
 * Version:			1.0.0
 * Website:			
 * 
 * File:			ConfiguratorWindow.java
 * Created:			2015/6/16
 * Last modified:	2015/7/29
 * Author:			Peter Folta <mail@peterfolta.net>
 */

package net.peterfolta.webview.gui;

import net.peterfolta.webview.common.URLMetaExtractor;
import net.peterfolta.webview.gui.common.DirectoryDialog;
import net.peterfolta.webview.gui.common.FileDialog;
import net.peterfolta.webview.main.Main;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.events.ShellListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageLoader;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.widgets.ToolTip;

public class ConfiguratorWindow {
	
	private Shell configuratorShell;
	
	private GridLayout gridLayout;
	private GridData gridData;
	
	private Menu mainMenu;
	private Menu fileMenu;
	private Menu helpMenu;
	
	private MenuItem fileMenuItem;
	private MenuItem openAppFileMenuItem;
	private MenuItem exitMenuItem;
	
	private MenuItem helpMenuItem;
	private MenuItem aboutItem;
	
	private Group appGroup;
	private Label appGroupUrlLabel;
	private Text appGroupUrlText;
	private Label appGroupTitleLabel;
	private Text appGroupTitleText;
	private Button appGroupDynamicPageTitleButton;
	
	private Group shortcutGroup;
	private Button shortcutStartButton;
	private Button shortcutDesktopButton;
	private Button shortcutQuickLaunchButton;
	
	private Group appOptGroup;
	private Label appOptGroupFileLabel;
	private Text appOptGroupFileText;
	private Button appOptGroupFileButton;
	private Label appOptGroupProfileLabel;
	private Text appOptGroupProfileText;
	private Button appOptGroupProfileButton;
	
	private Group optionsGroup;
	
	private Group iconGroup;
	private Button iconFaviconButton;
	private Button iconCustomButton;
	private Label iconPreviewLabel;
	
	private Composite ButtonCps;
	private Button ButtonCpsOkButton;
	private Button ButtonCpsExitButton;
	
	private boolean urldirty;
	
	public ConfiguratorWindow(Display display) {
		configuratorShell = new Shell(display, SWT.TITLE | SWT.MIN | SWT.CLOSE);
		configuratorShell.setText("WebView Configurator");
		
		configuratorShell.addShellListener(new ShellListener() {
			public void shellActivated(ShellEvent event) {
			}

			public void shellClosed(ShellEvent event) {
				Main.exit(0);
			}

			public void shellDeactivated(ShellEvent event) {
			}

			public void shellDeiconified(ShellEvent event) {
			}

			public void shellIconified(ShellEvent event) {
			}
		});
		
		gridLayout = new GridLayout();
		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.numColumns = 2;
		gridLayout.marginHeight = 15;
		gridLayout.marginWidth = 15;
		gridLayout.horizontalSpacing = 15;
		gridLayout.verticalSpacing = 15;
		configuratorShell.setLayout(gridLayout);
		
		appGroup = new Group(configuratorShell, SWT.NONE);
		appGroup.setText("Application");
		
		gridData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		appGroup.setLayoutData(gridData);
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.marginHeight = 10;
		gridLayout.marginWidth = 10;
		gridLayout.horizontalSpacing = 5;
		gridLayout.verticalSpacing = 10;
		appGroup.setLayout(gridLayout);
		
		appGroupUrlLabel = new Label(appGroup, SWT.NONE);
		appGroupUrlLabel.setText("URL:");
		
		gridData = new GridData();
		gridData.widthHint = 70;
		
		appGroupUrlLabel.setLayoutData(gridData);
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		
		appGroupUrlText = new Text(appGroup, SWT.BORDER);
		appGroupUrlText.setLayoutData(gridData);
		appGroupUrlText.addListener(SWT.Modify, new Listener() {
			public void handleEvent(Event event) {
				urldirty = true;
			}
		});
		appGroupUrlText.addListener(SWT.Deactivate, new Listener() {
			public void handleEvent(Event event) {
				if (urldirty) {
					urldirty = false;
					
					String url = appGroupUrlText.getText();
					URLMetaExtractor ume = new URLMetaExtractor(url);

					String title;
					try {
						title = ume.getPageTitle();
						appGroupTitleText.setText(title);
					} catch (Exception e) {
					} finally {
					}
				}
			}
		});
		
		appGroupTitleLabel = new Label(appGroup, SWT.NONE);
		appGroupTitleLabel.setText("Title:");
		
		gridData = new GridData();
		gridData.widthHint = 70;
		
		appGroupTitleLabel.setLayoutData(gridData);
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		
		appGroupTitleText = new Text(appGroup, SWT.BORDER);
		appGroupTitleText.setLayoutData(gridData);
		
		gridData = new GridData();
		gridData.horizontalSpan = 2;
		gridData.horizontalIndent = 75;
		
		appGroupDynamicPageTitleButton = new Button(appGroup, SWT.CHECK);
		appGroupDynamicPageTitleButton.setText("Use Dynamic Page Title");
		appGroupDynamicPageTitleButton.setLayoutData(gridData);
		appGroupDynamicPageTitleButton.setSelection(true);
		
		final ToolTip tip = new ToolTip(configuratorShell, SWT.BALLOON | SWT.ICON_INFORMATION);
		tip.setText("Use Dynamic Page Title");
		tip.setMessage("Use the web application's dynamic page title as the window title.\nOtherwise the title specified above will be used.");
		
		final Label icon = new Label(appGroup, SWT.NONE);
		icon.setImage(new Image(display, new ImageLoader().load("resources/icon_information.png")[0]));
		icon.addListener(SWT.MouseEnter, new Listener() {
			public void handleEvent(Event event) {
				Point loc = icon.toDisplay(icon.getSize());
				tip.setLocation(loc);
				tip.setVisible(true);
			}
		});
		icon.addListener(SWT.MouseExit, new Listener() {
			public void handleEvent(Event event) {
				tip.setVisible(false);
			}
		});
		
		shortcutGroup = new Group(configuratorShell, SWT.NONE);
		shortcutGroup.setText("Create Shortcuts");
		
		gridData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		shortcutGroup.setLayoutData(gridData);
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 1;
		gridLayout.marginHeight = 10;
		gridLayout.marginWidth = 10;
		gridLayout.horizontalSpacing = 5;
		gridLayout.verticalSpacing = 10;
		shortcutGroup.setLayout(gridLayout);
		
		shortcutStartButton = new Button(shortcutGroup, SWT.CHECK);
		shortcutStartButton.setText("Start / Start Menu");
		shortcutStartButton.setSelection(true);
		
		shortcutDesktopButton = new Button(shortcutGroup, SWT.CHECK);
		shortcutDesktopButton.setText("Desktop");
		shortcutDesktopButton.setSelection(true);
		
		shortcutQuickLaunchButton = new Button(shortcutGroup, SWT.CHECK);
		shortcutQuickLaunchButton.setText("Quick Launch Bar");
		
		appOptGroup = new Group(configuratorShell, SWT.NONE);
		appOptGroup.setText("Application Settings");
		
		gridData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		appOptGroup.setLayoutData(gridData);
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 3;
		gridLayout.marginHeight = 10;
		gridLayout.marginWidth = 10;
		gridLayout.horizontalSpacing = 5;
		gridLayout.verticalSpacing = 10;
		appOptGroup.setLayout(gridLayout);
		
		appOptGroupFileLabel = new Label(appOptGroup, SWT.NONE);
		appOptGroupFileLabel.setText("App File:");
		
		gridData = new GridData();
		gridData.widthHint = 70;
		
		appOptGroupFileLabel.setLayoutData(gridData);
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		
		appOptGroupFileText = new Text(appOptGroup, SWT.BORDER);
		appOptGroupFileText.setLayoutData(gridData);
		
		appOptGroupFileButton = new Button(appOptGroup, SWT.PUSH);
		appOptGroupFileButton.setText("Browse...");
		appOptGroupFileButton.addListener(SWT.Selection,  new Listener() {
			public void handleEvent(Event event) {
				String[] filterNames = new String[] { "WebView Application File (*.wvapp)", "All Files (*.*)" };
				String[] filterExtensions = new String[] { "*.wvapp", "*.*" };
				
				FileDialog appFileDialog = new FileDialog(configuratorShell, SWT.SAVE, "Save Application File", appOptGroupFileText.getText(), filterNames, filterExtensions);
				String appFile = appFileDialog.getPath();
				
				if (appFile != null) {
					appOptGroupFileText.setText(appFile);					
				}
			}
		});
		
		appOptGroupProfileLabel = new Label(appOptGroup, SWT.NONE);
		appOptGroupProfileLabel.setText("Profile Path:");
		
		gridData = new GridData();
		gridData.widthHint = 70;
		
		appOptGroupProfileLabel.setLayoutData(gridData);
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		
		appOptGroupProfileText = new Text(appOptGroup, SWT.BORDER);
		appOptGroupProfileText.setLayoutData(gridData);
		
		appOptGroupProfileButton = new Button(appOptGroup, SWT.PUSH);
		appOptGroupProfileButton.setText("Browse...");
		appOptGroupProfileButton.addListener(SWT.Selection,  new Listener() {
			public void handleEvent(Event event) {
				DirectoryDialog profilePathDialog = new DirectoryDialog(configuratorShell, "Select Profile Path", "Choose or create a new directory to store this web application's profile. It is recommended to select an empty directory.", appOptGroupProfileText.getText());
				String profilePath = profilePathDialog.getPath();
				
				if (profilePath != null) {
					appOptGroupProfileText.setText(profilePath);					
				}
			}
		});
		
		optionsGroup = new Group(configuratorShell, SWT.NONE);
		optionsGroup.setText("Options");
		
		gridData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		gridData.verticalSpan = 2;
		optionsGroup.setLayoutData(gridData);
		
		iconGroup = new Group(configuratorShell, SWT.NONE);
		iconGroup.setText("Icon");
		
		gridData = new GridData(GridData.VERTICAL_ALIGN_BEGINNING | GridData.FILL_BOTH);
		iconGroup.setLayoutData(gridData);
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.marginHeight = 10;
		gridLayout.marginWidth = 10;
		gridLayout.horizontalSpacing = 5;
		gridLayout.verticalSpacing = 10;
		iconGroup.setLayout(gridLayout);
		
		iconFaviconButton = new Button(iconGroup, SWT.RADIO);
		iconFaviconButton.setText("Use Favicon");
		iconFaviconButton.setSelection(true);
		
		gridData = new GridData();
		gridData.grabExcessHorizontalSpace = true;
		
		iconFaviconButton.setLayoutData(gridData);
		
		iconPreviewLabel = new Label(iconGroup, SWT.BORDER);
		
		gridData = new GridData();
		gridData.verticalSpan = 2;
		gridData.heightHint = 128;
		gridData.widthHint = 128;
		
		iconPreviewLabel.setLayoutData(gridData);
		
		iconCustomButton = new Button(iconGroup, SWT.RADIO);
		iconCustomButton.setText("Use Custom Icon");
		
		ButtonCps = new Composite(configuratorShell, SWT.NONE);
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		gridData.horizontalSpan = 2;
		gridData.horizontalAlignment = SWT.RIGHT;
		ButtonCps.setLayoutData(gridData);
		
		gridLayout = new GridLayout();
		gridLayout.numColumns = 2;
		gridLayout.makeColumnsEqualWidth = true;
		gridLayout.marginWidth = 0;
		ButtonCps.setLayout(gridLayout);
		
		ButtonCpsOkButton = new Button(ButtonCps, SWT.PUSH);
		ButtonCpsOkButton.setText("Create Application");
		ButtonCpsOkButton.setEnabled(false);
		
		gridData = new GridData();
		ButtonCpsOkButton.setLayoutData(gridData);

		ButtonCpsExitButton = new Button(ButtonCps, SWT.PUSH);
		ButtonCpsExitButton.setText("Exit");
		ButtonCpsExitButton.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Main.exit(0);
			}
		});
		
		gridData = new GridData(GridData.FILL_HORIZONTAL);
		ButtonCpsExitButton.setLayoutData(gridData);
		
		createMenu();

		configuratorShell.setMinimumSize(800, 0);
		configuratorShell.pack();
		configuratorShell.setDefaultButton(ButtonCpsOkButton);
		GUI.centerShellOnPrimaryMonitor(configuratorShell);
		configuratorShell.open();
	}
	
	private void createMenu() {
		mainMenu = new Menu(configuratorShell, SWT.BAR);
		configuratorShell.setMenuBar(mainMenu);
		
		fileMenuItem = new MenuItem(mainMenu, SWT.CASCADE);
		fileMenuItem.setText("&File");
		
		fileMenu = new Menu(fileMenuItem);
		fileMenuItem.setMenu(fileMenu);
		
		openAppFileMenuItem = new MenuItem(fileMenu, SWT.PUSH);
		openAppFileMenuItem.setText("&Open Application File...");
		
		new MenuItem(fileMenu, SWT.SEPARATOR);
		
		exitMenuItem = new MenuItem(fileMenu, SWT.PUSH);
		exitMenuItem.setText("E&xit");
		exitMenuItem.addListener(SWT.Selection, new Listener() {
			public void handleEvent(Event event) {
				Main.exit(0);
			}
		});
		
		helpMenuItem = new MenuItem(mainMenu, SWT.CASCADE);
		helpMenuItem.setText("&Help");
		
		helpMenu = new Menu(helpMenuItem);
		helpMenuItem.setMenu(helpMenu);
		
		aboutItem = new MenuItem(helpMenu, SWT.PUSH);
		aboutItem.setText("About WebView");
	}
	
}