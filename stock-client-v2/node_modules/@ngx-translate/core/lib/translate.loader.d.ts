import { Observable } from "rxjs";
import * as ɵngcc0 from '@angular/core';
export declare abstract class TranslateLoader {
    abstract getTranslation(lang: string): Observable<any>;
}
/**
 * This loader is just a placeholder that does nothing, in case you don't need a loader at all
 */
export declare class TranslateFakeLoader extends TranslateLoader {
    getTranslation(lang: string): Observable<any>;
    static ɵfac: ɵngcc0.ɵɵFactoryDef<TranslateFakeLoader>;
    static ɵprov: ɵngcc0.ɵɵInjectableDef<TranslateFakeLoader>;
}

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoidHJhbnNsYXRlLmxvYWRlci5kLnRzIiwic291cmNlcyI6WyJ0cmFuc2xhdGUubG9hZGVyLmQudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7O0FBQ0E7Ozs7Ozs7Ozs7QUFRQSIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7IE9ic2VydmFibGUgfSBmcm9tIFwicnhqc1wiO1xuZXhwb3J0IGRlY2xhcmUgYWJzdHJhY3QgY2xhc3MgVHJhbnNsYXRlTG9hZGVyIHtcbiAgICBhYnN0cmFjdCBnZXRUcmFuc2xhdGlvbihsYW5nOiBzdHJpbmcpOiBPYnNlcnZhYmxlPGFueT47XG59XG4vKipcbiAqIFRoaXMgbG9hZGVyIGlzIGp1c3QgYSBwbGFjZWhvbGRlciB0aGF0IGRvZXMgbm90aGluZywgaW4gY2FzZSB5b3UgZG9uJ3QgbmVlZCBhIGxvYWRlciBhdCBhbGxcbiAqL1xuZXhwb3J0IGRlY2xhcmUgY2xhc3MgVHJhbnNsYXRlRmFrZUxvYWRlciBleHRlbmRzIFRyYW5zbGF0ZUxvYWRlciB7XG4gICAgZ2V0VHJhbnNsYXRpb24obGFuZzogc3RyaW5nKTogT2JzZXJ2YWJsZTxhbnk+O1xufVxuIl19