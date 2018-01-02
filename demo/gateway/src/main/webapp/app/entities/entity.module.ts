import { NgModule, CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';

import { MijanStudentModule } from './student/student.module';
import { MijanAddressModule } from './address/address.module';
/* jhipster-needle-add-entity-module-import - JHipster will add entity modules imports here */

@NgModule({
    imports: [
        MijanStudentModule,
        MijanAddressModule,
        /* jhipster-needle-add-entity-module - JHipster will add entity modules here */
    ],
    declarations: [],
    entryComponents: [],
    providers: [],
    schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class MijanEntityModule {}
