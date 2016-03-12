/// <reference path="../../../../../../../../typings/browser.d.ts" />

import { Component } from 'angular2/core';
import { RouteConfig, ROUTER_DIRECTIVES, ROUTER_PROVIDERS } from 'angular2/router';
import {DashboardCmp} from '../../dashboard/components/dashboard';
import {LoginCmp} from '../../../pages/login/components/login';
@Component({
  selector: 'my-app',
  template: `
    <router-outlet></router-outlet>
  `,
  styleUrls: ['app/layout/base/components/app.component.css'],
  directives: [ROUTER_DIRECTIVES],
  providers: [
    ROUTER_PROVIDERS
  ]
})
@RouteConfig([
  { path: '/', component: LoginCmp, as: 'Login', useAsDefault:true},
  { path: '/dashboard/...', component: DashboardCmp, as: 'Dashboard' }
])
export class AppComponent {
  title = 'Tour of Heroes';
}


/*
Copyright 2016 Google Inc. All Rights Reserved.
Use of this source code is governed by an MIT-style license that
can be found in the LICENSE file at http://angular.io/license
*/
