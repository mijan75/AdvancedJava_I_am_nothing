import { BaseEntity } from './../../shared';

export class Address implements BaseEntity {
    constructor(
        public id?: number,
        public addressId?: BaseEntity,
        public presentAddress?: string,
        public permanentAddress?: string,
    ) {
    }
}
