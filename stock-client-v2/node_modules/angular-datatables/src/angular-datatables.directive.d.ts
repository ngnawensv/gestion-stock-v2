/**
 * @license
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at https://raw.githubusercontent.com/l-lin/angular-datatables/master/LICENSE
 */
/// <reference types="datatables.net" />
import { ElementRef, OnDestroy, OnInit } from '@angular/core';
import { Subject } from 'rxjs';
import * as ɵngcc0 from '@angular/core';
export declare class DataTableDirective implements OnDestroy, OnInit {
    private el;
    /**
     * The DataTable option you pass to configure your table.
     */
    dtOptions: DataTables.Settings;
    /**
     * This trigger is used if one wants to trigger manually the DT rendering
     * Useful when rendering angular rendered DOM
     */
    dtTrigger: Subject<any>;
    /**
     * The DataTable instance built by the jQuery library [DataTables](datatables.net).
     *
     * It's possible to execute the [DataTables APIs](https://datatables.net/reference/api/) with
     * this variable.
     */
    dtInstance: Promise<DataTables.Api>;
    private dt;
    constructor(el: ElementRef);
    ngOnInit(): void;
    ngOnDestroy(): void;
    private displayTable;
    static ɵfac: ɵngcc0.ɵɵFactoryDef<DataTableDirective>;
    static ɵdir: ɵngcc0.ɵɵDirectiveDefWithMeta<DataTableDirective, "[datatable]", never, {
    "dtOptions": "dtOptions";
    "dtTrigger": "dtTrigger";
}, {}, never>;
}

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYW5ndWxhci1kYXRhdGFibGVzLmRpcmVjdGl2ZS5kLnRzIiwic291cmNlcyI6WyJhbmd1bGFyLWRhdGF0YWJsZXMuZGlyZWN0aXZlLmQudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7Ozs7Ozs7Ozs7QUFTQTs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7OztBQXVCQSIsInNvdXJjZXNDb250ZW50IjpbIi8qKlxuICogQGxpY2Vuc2VcbiAqXG4gKiBVc2Ugb2YgdGhpcyBzb3VyY2UgY29kZSBpcyBnb3Zlcm5lZCBieSBhbiBNSVQtc3R5bGUgbGljZW5zZSB0aGF0IGNhbiBiZVxuICogZm91bmQgaW4gdGhlIExJQ0VOU0UgZmlsZSBhdCBodHRwczovL3Jhdy5naXRodWJ1c2VyY29udGVudC5jb20vbC1saW4vYW5ndWxhci1kYXRhdGFibGVzL21hc3Rlci9MSUNFTlNFXG4gKi9cbi8vLyA8cmVmZXJlbmNlIHR5cGVzPVwiZGF0YXRhYmxlcy5uZXRcIiAvPlxuaW1wb3J0IHsgRWxlbWVudFJlZiwgT25EZXN0cm95LCBPbkluaXQgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7IFN1YmplY3QgfSBmcm9tICdyeGpzJztcbmV4cG9ydCBkZWNsYXJlIGNsYXNzIERhdGFUYWJsZURpcmVjdGl2ZSBpbXBsZW1lbnRzIE9uRGVzdHJveSwgT25Jbml0IHtcbiAgICBwcml2YXRlIGVsO1xuICAgIC8qKlxuICAgICAqIFRoZSBEYXRhVGFibGUgb3B0aW9uIHlvdSBwYXNzIHRvIGNvbmZpZ3VyZSB5b3VyIHRhYmxlLlxuICAgICAqL1xuICAgIGR0T3B0aW9uczogRGF0YVRhYmxlcy5TZXR0aW5ncztcbiAgICAvKipcbiAgICAgKiBUaGlzIHRyaWdnZXIgaXMgdXNlZCBpZiBvbmUgd2FudHMgdG8gdHJpZ2dlciBtYW51YWxseSB0aGUgRFQgcmVuZGVyaW5nXG4gICAgICogVXNlZnVsIHdoZW4gcmVuZGVyaW5nIGFuZ3VsYXIgcmVuZGVyZWQgRE9NXG4gICAgICovXG4gICAgZHRUcmlnZ2VyOiBTdWJqZWN0PGFueT47XG4gICAgLyoqXG4gICAgICogVGhlIERhdGFUYWJsZSBpbnN0YW5jZSBidWlsdCBieSB0aGUgalF1ZXJ5IGxpYnJhcnkgW0RhdGFUYWJsZXNdKGRhdGF0YWJsZXMubmV0KS5cbiAgICAgKlxuICAgICAqIEl0J3MgcG9zc2libGUgdG8gZXhlY3V0ZSB0aGUgW0RhdGFUYWJsZXMgQVBJc10oaHR0cHM6Ly9kYXRhdGFibGVzLm5ldC9yZWZlcmVuY2UvYXBpLykgd2l0aFxuICAgICAqIHRoaXMgdmFyaWFibGUuXG4gICAgICovXG4gICAgZHRJbnN0YW5jZTogUHJvbWlzZTxEYXRhVGFibGVzLkFwaT47XG4gICAgcHJpdmF0ZSBkdDtcbiAgICBjb25zdHJ1Y3RvcihlbDogRWxlbWVudFJlZik7XG4gICAgbmdPbkluaXQoKTogdm9pZDtcbiAgICBuZ09uRGVzdHJveSgpOiB2b2lkO1xuICAgIHByaXZhdGUgZGlzcGxheVRhYmxlO1xufVxuIl19