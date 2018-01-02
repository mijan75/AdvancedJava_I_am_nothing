import { BaseEntity } from './../../shared';

export class Student implements BaseEntity {
    constructor(
        public id?: number,
        public name?: string,
    ) {
    }
}
