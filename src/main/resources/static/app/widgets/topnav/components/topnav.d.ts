import { Router } from 'angular2/router';
export declare class TopNavCmp {
    private _router;
    oneAtATime: boolean;
    items: Array<any>;
    status: Object;
    constructor(_router: Router);
    gotoDashboard(): void;
}
