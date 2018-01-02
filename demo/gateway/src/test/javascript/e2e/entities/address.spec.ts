import { browser, element, by, $ } from 'protractor';
import { NavBarPage } from './../page-objects/jhi-page-objects';
const path = require('path');

describe('Address e2e test', () => {

    let navBarPage: NavBarPage;
    let addressDialogPage: AddressDialogPage;
    let addressComponentsPage: AddressComponentsPage;
    const fileToUpload = '../../../../main/webapp/content/images/logo-jhipster.png';
    const absolutePath = path.resolve(__dirname, fileToUpload);
    

    beforeAll(() => {
        browser.get('/');
        browser.waitForAngular();
        navBarPage = new NavBarPage();
        navBarPage.getSignInPage().autoSignInUsing('admin', 'admin');
        browser.waitForAngular();
    });

    it('should load Addresses', () => {
        navBarPage.goToEntity('address');
        addressComponentsPage = new AddressComponentsPage();
        expect(addressComponentsPage.getTitle()).toMatch(/mijanApp.address.home.title/);

    });

    it('should load create Address dialog', () => {
        addressComponentsPage.clickOnCreateButton();
        addressDialogPage = new AddressDialogPage();
        expect(addressDialogPage.getModalTitle()).toMatch(/mijanApp.address.home.createOrEditLabel/);
        addressDialogPage.close();
    });

    it('should create and save Addresses', () => {
        addressComponentsPage.clickOnCreateButton();
        addressDialogPage.setAddressIdInput('addressId');
        expect(addressDialogPage.getAddressIdInput()).toMatch('addressId');
        addressDialogPage.setPresentAddressInput('presentAddress');
        expect(addressDialogPage.getPresentAddressInput()).toMatch('presentAddress');
        addressDialogPage.setPermanentAddressInput('permanentAddress');
        expect(addressDialogPage.getPermanentAddressInput()).toMatch('permanentAddress');
        addressDialogPage.addressIdSelectLastOption();
        addressDialogPage.save();
        expect(addressDialogPage.getSaveButton().isPresent()).toBeFalsy();
    }); 

    afterAll(() => {
        navBarPage.autoSignOut();
    });
});

export class AddressComponentsPage {
    createButton = element(by.css('.jh-create-entity'));
    title = element.all(by.css('jhi-address div h2 span')).first();

    clickOnCreateButton() {
        return this.createButton.click();
    }

    getTitle() {
        return this.title.getAttribute('jhiTranslate');
    }
}

export class AddressDialogPage {
    modalTitle = element(by.css('h4#myAddressLabel'));
    saveButton = element(by.css('.modal-footer .btn.btn-primary'));
    closeButton = element(by.css('button.close'));
    addressIdInput = element(by.css('input#field_addressId'));
    presentAddressInput = element(by.css('input#field_presentAddress'));
    permanentAddressInput = element(by.css('input#field_permanentAddress'));
    addressIdSelect = element(by.css('select#field_addressId'));

    getModalTitle() {
        return this.modalTitle.getAttribute('jhiTranslate');
    }

    setAddressIdInput = function (addressId) {
        this.addressIdInput.sendKeys(addressId);
    }

    getAddressIdInput = function () {
        return this.addressIdInput.getAttribute('value');
    }

    setPresentAddressInput = function (presentAddress) {
        this.presentAddressInput.sendKeys(presentAddress);
    }

    getPresentAddressInput = function () {
        return this.presentAddressInput.getAttribute('value');
    }

    setPermanentAddressInput = function (permanentAddress) {
        this.permanentAddressInput.sendKeys(permanentAddress);
    }

    getPermanentAddressInput = function () {
        return this.permanentAddressInput.getAttribute('value');
    }

    addressIdSelectLastOption = function () {
        this.addressIdSelect.all(by.tagName('option')).last().click();
    }

    addressIdSelectOption = function (option) {
        this.addressIdSelect.sendKeys(option);
    }

    getAddressIdSelect = function () {
        return this.addressIdSelect;
    }

    getAddressIdSelectedOption = function () {
        return this.addressIdSelect.element(by.css('option:checked')).getText();
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
