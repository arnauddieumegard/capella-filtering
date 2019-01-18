/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.filtering.tools.preferences;

import org.eclipse.jface.preference.BooleanFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;
import org.polarsys.capella.common.ui.toolkit.fields.SpacerFieldEditor;
import org.polarsys.capella.filtering.tools.FilteringToolsPlugin;

/**
 * Variability preferences page. The Activator of this plugin contains the listener to refresh when the user click Apply
 * 
 * 
 */
public class FilteringPreferencesPage extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

  public static final String FEATURES_DIAGRAM = "FEATURES_DIAGRAM"; //$NON-NLS-1$
  public static final String OPTIONAL_DIAGRAM = "OPTIONAL_DIAGRAM"; //$NON-NLS-1$
  public static final String SAVE_DECORATORS_DIAGRAM = "SAVE_DECORATORS_DIAGRAM"; //$NON-NLS-1$
  public static final String APPLICATION_PROJECT_WITH_DIFFERENT_ID = "APPLICATION_PROJECT_WITH_DIFFERENT_ID"; //$NON-NLS-1$

  public FilteringPreferencesPage() {
    super(GRID);
  }

  /**
   * @return preferences page ID
   */
  public static String getID() {
    return "org.polarsys.capella.filtering.tools.page"; //$NON-NLS-1$
  }

  @Override
  public void createFieldEditors() {
    addField(new BooleanFieldEditor(FEATURES_DIAGRAM, Messages.FILTERING_PREFERENCES_PAGE_0, getFieldEditorParent()));
    addField(new BooleanFieldEditor(OPTIONAL_DIAGRAM, Messages.FILTERING_PREFERENCES_PAGE_1, getFieldEditorParent()));
    SpacerFieldEditor spacer = new SpacerFieldEditor(getFieldEditorParent());
    addField(spacer);
    addField(
        new BooleanFieldEditor(SAVE_DECORATORS_DIAGRAM, Messages.FILTERING_PREFERENCES_PAGE_2, getFieldEditorParent()));
    addField(spacer);
    addField(new BooleanFieldEditor(APPLICATION_PROJECT_WITH_DIFFERENT_ID, Messages.FILTERING_PREFERENCES_PAGE_3,
        getFieldEditorParent()));
  }

  @Override
  public void init(IWorkbench workbench) {
    setPreferenceStore(FilteringToolsPlugin.getDefault().getPreferenceStore());
    setDescription(Messages.FILTERING_PREFERENCES_PAGE_4);
  }

}
