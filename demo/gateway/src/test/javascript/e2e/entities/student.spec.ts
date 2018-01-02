import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Student e2e test', () => {

    let navBarPage: NavBarPage;
    let studentDialogPage: StudentDialogPage;
    let studentComponentsPage: StudentComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Students', () => {
        navBarPage.goToEntity('student');
        studentComponentsPage = new StudentComponentsPage();
        expect(studentComponentsPage.getTitle()).toMatch(/mijanApp.student.home.title/);

    });

    it('should load create Student dialog', () => {
        studentComponentsPage.clickOnCreateButton();
        studentDialogPage = new StudentDialogPage();
        expect(studentDialogPage.getModalTitle()).toMatch(/mijanApp.student.home.createOrEditLabel/);
        studentDialogPage.close();
    });

    it('should create and save Students', () => {
        studentComponentsPage.clickOnCreateButton();
        studentDialogPage.setNameInput('name');
        expect(studentDialogPage.getNameInput()).toMatch('name');
        studentDialogPage.save();
        expect(studentDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class StudentComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-student div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class StudentDialogPage {
    modalTitle = element(by.css('h4#myStudentLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    nameInput = element(by.css('input#field_name'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setNameInput = function (name) {
        this.nameInput.sendKeys(name);
    }

    getNameInput = function () {
        return this.nameInput.getAttribute('value');
    }

    save() {
        this.saveButton.click();
    }

    close() {
        this.closeButton.click();
    }

    getSaveButton() {
        return this.saveButton;
    }
}
