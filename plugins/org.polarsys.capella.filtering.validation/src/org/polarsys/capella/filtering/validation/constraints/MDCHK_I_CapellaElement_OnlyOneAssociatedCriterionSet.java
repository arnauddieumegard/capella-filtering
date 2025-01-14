/*******************************************************************************
 * Copyright (c) 2018 THALES GLOBAL SERVICES.
 * 
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 * 
 * SPDX-License-Identifier: EPL-2.0
 * 
 * Contributors:
 *    Thales - initial API and implementation
 *******************************************************************************/
package org.polarsys.capella.filtering.validation.constraints;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.AbstractModelConstraint;
import org.eclipse.emf.validation.EMFEventType;
import org.eclipse.emf.validation.IValidationContext;
import org.polarsys.capella.core.data.capellacore.CapellaElement;
import org.polarsys.capella.filtering.AssociatedFilteringCriterionSet;
import org.polarsys.kitalpha.emde.model.ElementExtension;

/**
 * 
 */
public class MDCHK_I_CapellaElement_OnlyOneAssociatedCriterionSet extends AbstractModelConstraint {

  @Override
  public IStatus validate(IValidationContext ctx) {
    EObject eObj = ctx.getTarget();
    EMFEventType eType = ctx.getEventType();
    // check that it is batch validation
    if (eType == EMFEventType.NULL) {
      if (eObj instanceof CapellaElement) {
        CapellaElement capellaElement = (CapellaElement) eObj;
        boolean oneFound = false;
        for (ElementExtension elementExtension : capellaElement.getOwnedExtensions()) {
          if (elementExtension instanceof AssociatedFilteringCriterionSet) {
            if (oneFound) {
              // One was previously found so this is the second.
              // Return failure
              return ctx.createFailureStatus(ConstraintsUtil.getNameForMessage(capellaElement));
            }
            oneFound = true;
          }
        }
      }
    }
    return ctx.createSuccessStatus();
  }

}
