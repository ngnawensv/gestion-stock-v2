/**
 * @license
 *
 * Use of this source code is governed by an MIT-style license that can be
 * found in the LICENSE file at https://raw.githubusercontent.com/l-lin/angular-datatables/master/LICENSE
 */
import * as ɵngcc0 from '@angular/core';
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { DataTableDirective } from './angular-datatables.directive';
var DataTablesModule = /** @class */ (function () {
    function DataTablesModule() {
    }
    DataTablesModule_1 = DataTablesModule;
    DataTablesModule.forRoot = function () {
        return {
            ngModule: DataTablesModule_1
        };
    };
    var DataTablesModule_1;
DataTablesModule.ɵmod = ɵngcc0.ɵɵdefineNgModule({ type: DataTablesModule });
DataTablesModule.ɵinj = ɵngcc0.ɵɵdefineInjector({ factory: function DataTablesModule_Factory(t) { return new (t || DataTablesModule)(); }, imports: [[CommonModule]] });
(function () { (typeof ngJitMode === "undefined" || ngJitMode) && ɵngcc0.ɵɵsetNgModuleScope(DataTablesModule, { declarations: function () { return [DataTableDirective]; }, imports: function () { return [CommonModule]; }, exports: function () { return [DataTableDirective]; } }); })();
/*@__PURE__*/ (function () { ɵngcc0.ɵsetClassMetadata(DataTablesModule, [{
        type: NgModule,
        args: [{
                imports: [CommonModule],
                declarations: [DataTableDirective],
                exports: [DataTableDirective]
            }]
    }], function () { return []; }, null); })();
    return DataTablesModule;
}());
export { DataTablesModule };

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYW5ndWxhci1kYXRhdGFibGVzLm1vZHVsZS5qcyIsInNvdXJjZXMiOlsiYW5ndWxhci1kYXRhdGFibGVzLm1vZHVsZS5qcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTs7Ozs7OztBQU1BOzs7Ozs7Ozs7Ozs7Ozs7Ozs7MkJBa0IyQjs7Ozs7Ozs7Ozs7Z0RBT0YiLCJzb3VyY2VzQ29udGVudCI6WyIvKipcbiAqIEBsaWNlbnNlXG4gKlxuICogVXNlIG9mIHRoaXMgc291cmNlIGNvZGUgaXMgZ292ZXJuZWQgYnkgYW4gTUlULXN0eWxlIGxpY2Vuc2UgdGhhdCBjYW4gYmVcbiAqIGZvdW5kIGluIHRoZSBMSUNFTlNFIGZpbGUgYXQgaHR0cHM6Ly9yYXcuZ2l0aHVidXNlcmNvbnRlbnQuY29tL2wtbGluL2FuZ3VsYXItZGF0YXRhYmxlcy9tYXN0ZXIvTElDRU5TRVxuICovXG52YXIgX19kZWNvcmF0ZSA9ICh0aGlzICYmIHRoaXMuX19kZWNvcmF0ZSkgfHwgZnVuY3Rpb24gKGRlY29yYXRvcnMsIHRhcmdldCwga2V5LCBkZXNjKSB7XG4gICAgdmFyIGMgPSBhcmd1bWVudHMubGVuZ3RoLCByID0gYyA8IDMgPyB0YXJnZXQgOiBkZXNjID09PSBudWxsID8gZGVzYyA9IE9iamVjdC5nZXRPd25Qcm9wZXJ0eURlc2NyaXB0b3IodGFyZ2V0LCBrZXkpIDogZGVzYywgZDtcbiAgICBpZiAodHlwZW9mIFJlZmxlY3QgPT09IFwib2JqZWN0XCIgJiYgdHlwZW9mIFJlZmxlY3QuZGVjb3JhdGUgPT09IFwiZnVuY3Rpb25cIikgciA9IFJlZmxlY3QuZGVjb3JhdGUoZGVjb3JhdG9ycywgdGFyZ2V0LCBrZXksIGRlc2MpO1xuICAgIGVsc2UgZm9yICh2YXIgaSA9IGRlY29yYXRvcnMubGVuZ3RoIC0gMTsgaSA+PSAwOyBpLS0pIGlmIChkID0gZGVjb3JhdG9yc1tpXSkgciA9IChjIDwgMyA/IGQocikgOiBjID4gMyA/IGQodGFyZ2V0LCBrZXksIHIpIDogZCh0YXJnZXQsIGtleSkpIHx8IHI7XG4gICAgcmV0dXJuIGMgPiAzICYmIHIgJiYgT2JqZWN0LmRlZmluZVByb3BlcnR5KHRhcmdldCwga2V5LCByKSwgcjtcbn07XG5pbXBvcnQgeyBOZ01vZHVsZSB9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xuaW1wb3J0IHsgQ29tbW9uTW9kdWxlIH0gZnJvbSAnQGFuZ3VsYXIvY29tbW9uJztcbmltcG9ydCB7IERhdGFUYWJsZURpcmVjdGl2ZSB9IGZyb20gJy4vYW5ndWxhci1kYXRhdGFibGVzLmRpcmVjdGl2ZSc7XG52YXIgRGF0YVRhYmxlc01vZHVsZSA9IC8qKiBAY2xhc3MgKi8gKGZ1bmN0aW9uICgpIHtcbiAgICBmdW5jdGlvbiBEYXRhVGFibGVzTW9kdWxlKCkge1xuICAgIH1cbiAgICBEYXRhVGFibGVzTW9kdWxlXzEgPSBEYXRhVGFibGVzTW9kdWxlO1xuICAgIERhdGFUYWJsZXNNb2R1bGUuZm9yUm9vdCA9IGZ1bmN0aW9uICgpIHtcbiAgICAgICAgcmV0dXJuIHtcbiAgICAgICAgICAgIG5nTW9kdWxlOiBEYXRhVGFibGVzTW9kdWxlXzFcbiAgICAgICAgfTtcbiAgICB9O1xuICAgIHZhciBEYXRhVGFibGVzTW9kdWxlXzE7XG4gICAgRGF0YVRhYmxlc01vZHVsZSA9IERhdGFUYWJsZXNNb2R1bGVfMSA9IF9fZGVjb3JhdGUoW1xuICAgICAgICBOZ01vZHVsZSh7XG4gICAgICAgICAgICBpbXBvcnRzOiBbQ29tbW9uTW9kdWxlXSxcbiAgICAgICAgICAgIGRlY2xhcmF0aW9uczogW0RhdGFUYWJsZURpcmVjdGl2ZV0sXG4gICAgICAgICAgICBleHBvcnRzOiBbRGF0YVRhYmxlRGlyZWN0aXZlXVxuICAgICAgICB9KVxuICAgIF0sIERhdGFUYWJsZXNNb2R1bGUpO1xuICAgIHJldHVybiBEYXRhVGFibGVzTW9kdWxlO1xufSgpKTtcbmV4cG9ydCB7IERhdGFUYWJsZXNNb2R1bGUgfTtcbiJdfQ==