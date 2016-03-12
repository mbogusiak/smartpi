import {Component, ViewEncapsulation} from 'angular2/core';
import {
RouteConfig,
ROUTER_DIRECTIVES
} from 'angular2/router';

import {HomeCmp} from '../../../pages/home/components/home';
import {TopNavCmp} from '../../../widgets/topnav/components/topnav';
import {SidebarCmp} from '../../../widgets/sidebar/components/sidebar';
import {TableCmp} from '../../../pages/tables/components/tables';

@Component({
  selector: 'dashboard',
  templateUrl: 'app/layout/dashboard/components/dashboard.html',
  encapsulation: ViewEncapsulation.None,
  directives: [ROUTER_DIRECTIVES, TopNavCmp, SidebarCmp]
})
@RouteConfig([
  { path: '/', component: HomeCmp, as: 'Home', useAsDefault:true},
  { path: '/tables', component: TableCmp, as: 'Tables' },
])
export class DashboardCmp { }
