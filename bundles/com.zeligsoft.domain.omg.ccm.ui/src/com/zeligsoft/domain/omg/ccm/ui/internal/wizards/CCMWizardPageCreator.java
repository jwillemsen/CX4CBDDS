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
package com.zeligsoft.domain.omg.ccm.ui.internal.wizards;

import org.eclipse.ui.dialogs.WizardNewProjectCreationPage;

import com.zeligsoft.cx.ui.pages.ZeligsoftModelWizardPage;
import com.zeligsoft.domain.omg.ccm.ui.l10n.Messages;

/**
 * A singleton class that creates the pages for the CCM new model and project
 * wizards.
 * 
 * @author Toby McClean (tmcclean)
 * 
 */
public class CCMWizardPageCreator {
	public static final String MODEL_NAME = Messages.Wizard__Default_Model_name;

	public static final String MODEL_NAME_EXTENSION = "emx"; //$NON-NLS-1$
	public static final String MODEL_FILE_NAME = MODEL_NAME
			+ "." + MODEL_NAME_EXTENSION; //$NON-NLS-1$

	public static final String TEMPLATE_FILE_PATH = "/templates/ccmModelTemplate.emx"; //$NON-NLS-1$

	public static final String PROJECT_PAGE_NAME = "CCMProjectPage"; //$NON-NLS-1$
	public static final String MODEL_PAGE_NAME = "CCMModelPage"; //$NON-NLS-1$

	/**
	 * Singleton instance since I have no state
	 */
	public static final CCMWizardPageCreator INSTANCE = new CCMWizardPageCreator();

	/**
	 * Initialize me
	 */
	private CCMWizardPageCreator() {
		// do nothing
	}

	public WizardNewProjectCreationPage createProjectPage() {
		WizardNewProjectCreationPage projectPage = new WizardNewProjectCreationPage(
				PROJECT_PAGE_NAME);
		projectPage.setTitle(Messages.Wizard__NewProjectPage_title);
		projectPage.setDescription(Messages.Wizard__NewProjectPage_description);

		return projectPage;
	}

	public ZeligsoftModelWizardPage createModelPage(String modelName) {
		ZeligsoftModelWizardPage modelPage = new ZeligsoftModelWizardPage(
				MODEL_PAGE_NAME);
		modelPage.setTitle(Messages.Wizard__NewModelPage_title);
		modelPage.setDefaultModelName(modelName);
		modelPage.setDescription(Messages.Wizard__NewModelPage_description);

		return modelPage;
	}

	public ZeligsoftModelWizardPage createModelPage() {
		return createModelPage(MODEL_NAME);
	}

}
