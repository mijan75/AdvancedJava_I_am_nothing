import { Injectable } from '@angular/core';
import { Resolve, ActivatedRouteSnapshot, RouterStateSnapshot, Routes } from '@angular/router';

import { UserRouteAccessService } from '../../shared';
import { JhiPaginationUtil } from 'ng-jhipster';

import { AddressComponent } from './address.component';
import { AddressDetailComponent } from './address-detail.component';
import { AddressPopupComponent } from './address-dialog.component';
import { AddressDeletePopupComponent } from './address-delete-dialog.component';

export const addressRoute: Routes = [
    {
        path: 'address',
        component: AddressComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'mijanApp.address.home.title'
        },
        canActivate: [UserRouteAccessService]
    }, {
        path: 'address/:id',
        component: AddressDetailComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'mijanApp.address.home.title'
        },
        canActivate: [UserRouteAccessService]
    }
];

export const addressPopupRoute: Routes = [
    {
        path: 'address-new',
        component: AddressPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'mijanApp.address.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'address/:id/edit',
        component: AddressPopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'mijanApp.address.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    },
    {
        path: 'address/:id/delete',
        component: AddressDeletePopupComponent,
        data: {
            authorities: ['ROLE_USER'],
            pageTitle: 'mijanApp.address.home.title'
        },
        canActivate: [UserRouteAccessService],
        outlet: 'popup'
    }
];
