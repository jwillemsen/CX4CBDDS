/**
 * Copyright 2018 ADLINK Technology Limited.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.zeligsoft.base.deployment.rsm.tooling.figures;

import com.zeligsoft.base.deployment.rsm.tooling.l10n.ZeligsoftDeploymentMessages;

import org.eclipse.draw2d.RectangleFigure;

import org.eclipse.gmf.runtime.draw2d.ui.figures.WrapLabel;

/**
 * @generated
 */
public class DeploymentPartPropertyFigure
        extends RectangleFigure {
    
    /**
     * @generated
     */
    private WrapLabel mainFigure, nameFigure;
    
    /**
     * @generated
     */
    public DeploymentPartPropertyFigure() {
        createContents();
    }

    /**
     * @generated
     */
    private void createContents() {
        mainFigure = new WrapLabel();
        mainFigure.setText(ZeligsoftDeploymentMessages.DeploymentPartPropertyFigure_text);
        this.add(mainFigure, null);

        nameFigure = new WrapLabel();
        this.add(nameFigure, null);
    }

    /**
     * @generated
     */
    public WrapLabel getMainFigure() {
        return mainFigure;
    }

    /**
     * @generated
     */
    public WrapLabel getNameFigure() {
        return nameFigure;
    }

}