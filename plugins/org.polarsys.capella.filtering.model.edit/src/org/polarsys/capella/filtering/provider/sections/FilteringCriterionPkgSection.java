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
package org.polarsys.capella.filtering.provider.sections;

import org.eclipse.emf.ecore.EObject;
import org.polarsys.capella.core.data.core.properties.sections.NamedElementSection;
import org.polarsys.capella.core.model.handler.helpers.CapellaAdapterHelper;
import org.polarsys.capella.filtering.FilteringCriterionPkg;

/**
 * This is the item provider adapter for a {@link FilteringCriterionPkgSection} object. <!-- begin-user-doc --> <!--
 * end-user-doc -->
 * 
 * @generated
 */
public class FilteringCriterionPkgSection extends NamedElementSection {
  /**
   * @generated
   */
  @Override
  public boolean select(Object toTest) {
    EObject obj = CapellaAdapterHelper.resolveSemanticObject(toTest);

    return obj != null
        && obj.eClass().equals(org.polarsys.capella.filtering.FilteringPackage.eINSTANCE.getFilteringCriterionPkg());
  }
}
