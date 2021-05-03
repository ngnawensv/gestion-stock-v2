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
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
import { Directive, ElementRef, Input } from '@angular/core';
import { Subject } from 'rxjs';
var DataTableDirective = /** @class */ (function () {
    function DataTableDirective(el) {
        this.el = el;
        /**
         * The DataTable option you pass to configure your table.
         */
        this.dtOptions = {};
    }
    DataTableDirective.prototype.ngOnInit = function () {
        var _this = this;
        if (this.dtTrigger) {
            this.dtTrigger.subscribe(function () {
                _this.displayTable();
            });
        }
        else {
            this.displayTable();
        }
    };
    DataTableDirective.prototype.ngOnDestroy = function () {
        if (this.dtTrigger) {
            this.dtTrigger.unsubscribe();
        }
        if (this.dt) {
            this.dt.destroy(true);
        }
    };
    DataTableDirective.prototype.displayTable = function () {
        var _this = this;
        this.dtInstance = new Promise(function (resolve, reject) {
            Promise.resolve(_this.dtOptions).then(function (dtOptions) {
                // Using setTimeout as a "hack" to be "part" of NgZone
                setTimeout(function () {
                    _this.dt = $(_this.el.nativeElement).DataTable(dtOptions);
                    resolve(_this.dt);
                });
            });
        });
    };
    __decorate([
        Input(),
        __metadata("design:type", Object)
    ], DataTableDirective.prototype, "dtOptions", void 0);
    __decorate([
        Input(),
        __metadata("design:type", Subject)
    ], DataTableDirective.prototype, "dtTrigger", void 0);
    DataTableDirective = __decorate([ __metadata("design:paramtypes", [ElementRef])
    ], DataTableDirective);
DataTableDirective.ɵfac = function DataTableDirective_Factory(t) { return new (t || DataTableDirective)(ɵngcc0.ɵɵdirectiveInject(ɵngcc0.ElementRef)); };
DataTableDirective.ɵdir = ɵngcc0.ɵɵdefineDirective({ type: DataTableDirective, selectors: [["", "datatable", ""]], inputs: { dtOptions: "dtOptions", dtTrigger: "dtTrigger" } });
/*@__PURE__*/ (function () { ɵngcc0.ɵsetClassMetadata(DataTableDirective, [{
        type: Directive,
        args: [{
                selector: '[datatable]'
            }]
    }], function () { return [{ type: ɵngcc0.ElementRef }]; }, { dtOptions: [{
            type: Input
        }], dtTrigger: [{
            type: Input
        }] }); })();
    return DataTableDirective;
}());
export { DataTableDirective };

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoiYW5ndWxhci1kYXRhdGFibGVzLmRpcmVjdGl2ZS5qcyIsInNvdXJjZXMiOlsiYW5ndWxhci1kYXRhdGFibGVzLmRpcmVjdGl2ZS5qcyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTs7Ozs7OztBQU1BOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7O3FDQTBEcUMsQUFJOUI7Ozs7Ozs7Ozs7Ozs7b0JBQ29CIiwic291cmNlc0NvbnRlbnQiOlsiLyoqXG4gKiBAbGljZW5zZVxuICpcbiAqIFVzZSBvZiB0aGlzIHNvdXJjZSBjb2RlIGlzIGdvdmVybmVkIGJ5IGFuIE1JVC1zdHlsZSBsaWNlbnNlIHRoYXQgY2FuIGJlXG4gKiBmb3VuZCBpbiB0aGUgTElDRU5TRSBmaWxlIGF0IGh0dHBzOi8vcmF3LmdpdGh1YnVzZXJjb250ZW50LmNvbS9sLWxpbi9hbmd1bGFyLWRhdGF0YWJsZXMvbWFzdGVyL0xJQ0VOU0VcbiAqL1xudmFyIF9fZGVjb3JhdGUgPSAodGhpcyAmJiB0aGlzLl9fZGVjb3JhdGUpIHx8IGZ1bmN0aW9uIChkZWNvcmF0b3JzLCB0YXJnZXQsIGtleSwgZGVzYykge1xuICAgIHZhciBjID0gYXJndW1lbnRzLmxlbmd0aCwgciA9IGMgPCAzID8gdGFyZ2V0IDogZGVzYyA9PT0gbnVsbCA/IGRlc2MgPSBPYmplY3QuZ2V0T3duUHJvcGVydHlEZXNjcmlwdG9yKHRhcmdldCwga2V5KSA6IGRlc2MsIGQ7XG4gICAgaWYgKHR5cGVvZiBSZWZsZWN0ID09PSBcIm9iamVjdFwiICYmIHR5cGVvZiBSZWZsZWN0LmRlY29yYXRlID09PSBcImZ1bmN0aW9uXCIpIHIgPSBSZWZsZWN0LmRlY29yYXRlKGRlY29yYXRvcnMsIHRhcmdldCwga2V5LCBkZXNjKTtcbiAgICBlbHNlIGZvciAodmFyIGkgPSBkZWNvcmF0b3JzLmxlbmd0aCAtIDE7IGkgPj0gMDsgaS0tKSBpZiAoZCA9IGRlY29yYXRvcnNbaV0pIHIgPSAoYyA8IDMgPyBkKHIpIDogYyA+IDMgPyBkKHRhcmdldCwga2V5LCByKSA6IGQodGFyZ2V0LCBrZXkpKSB8fCByO1xuICAgIHJldHVybiBjID4gMyAmJiByICYmIE9iamVjdC5kZWZpbmVQcm9wZXJ0eSh0YXJnZXQsIGtleSwgciksIHI7XG59O1xudmFyIF9fbWV0YWRhdGEgPSAodGhpcyAmJiB0aGlzLl9fbWV0YWRhdGEpIHx8IGZ1bmN0aW9uIChrLCB2KSB7XG4gICAgaWYgKHR5cGVvZiBSZWZsZWN0ID09PSBcIm9iamVjdFwiICYmIHR5cGVvZiBSZWZsZWN0Lm1ldGFkYXRhID09PSBcImZ1bmN0aW9uXCIpIHJldHVybiBSZWZsZWN0Lm1ldGFkYXRhKGssIHYpO1xufTtcbmltcG9ydCB7IERpcmVjdGl2ZSwgRWxlbWVudFJlZiwgSW5wdXQgfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7IFN1YmplY3QgfSBmcm9tICdyeGpzJztcbnZhciBEYXRhVGFibGVEaXJlY3RpdmUgPSAvKiogQGNsYXNzICovIChmdW5jdGlvbiAoKSB7XG4gICAgZnVuY3Rpb24gRGF0YVRhYmxlRGlyZWN0aXZlKGVsKSB7XG4gICAgICAgIHRoaXMuZWwgPSBlbDtcbiAgICAgICAgLyoqXG4gICAgICAgICAqIFRoZSBEYXRhVGFibGUgb3B0aW9uIHlvdSBwYXNzIHRvIGNvbmZpZ3VyZSB5b3VyIHRhYmxlLlxuICAgICAgICAgKi9cbiAgICAgICAgdGhpcy5kdE9wdGlvbnMgPSB7fTtcbiAgICB9XG4gICAgRGF0YVRhYmxlRGlyZWN0aXZlLnByb3RvdHlwZS5uZ09uSW5pdCA9IGZ1bmN0aW9uICgpIHtcbiAgICAgICAgdmFyIF90aGlzID0gdGhpcztcbiAgICAgICAgaWYgKHRoaXMuZHRUcmlnZ2VyKSB7XG4gICAgICAgICAgICB0aGlzLmR0VHJpZ2dlci5zdWJzY3JpYmUoZnVuY3Rpb24gKCkge1xuICAgICAgICAgICAgICAgIF90aGlzLmRpc3BsYXlUYWJsZSgpO1xuICAgICAgICAgICAgfSk7XG4gICAgICAgIH1cbiAgICAgICAgZWxzZSB7XG4gICAgICAgICAgICB0aGlzLmRpc3BsYXlUYWJsZSgpO1xuICAgICAgICB9XG4gICAgfTtcbiAgICBEYXRhVGFibGVEaXJlY3RpdmUucHJvdG90eXBlLm5nT25EZXN0cm95ID0gZnVuY3Rpb24gKCkge1xuICAgICAgICBpZiAodGhpcy5kdFRyaWdnZXIpIHtcbiAgICAgICAgICAgIHRoaXMuZHRUcmlnZ2VyLnVuc3Vic2NyaWJlKCk7XG4gICAgICAgIH1cbiAgICAgICAgaWYgKHRoaXMuZHQpIHtcbiAgICAgICAgICAgIHRoaXMuZHQuZGVzdHJveSh0cnVlKTtcbiAgICAgICAgfVxuICAgIH07XG4gICAgRGF0YVRhYmxlRGlyZWN0aXZlLnByb3RvdHlwZS5kaXNwbGF5VGFibGUgPSBmdW5jdGlvbiAoKSB7XG4gICAgICAgIHZhciBfdGhpcyA9IHRoaXM7XG4gICAgICAgIHRoaXMuZHRJbnN0YW5jZSA9IG5ldyBQcm9taXNlKGZ1bmN0aW9uIChyZXNvbHZlLCByZWplY3QpIHtcbiAgICAgICAgICAgIFByb21pc2UucmVzb2x2ZShfdGhpcy5kdE9wdGlvbnMpLnRoZW4oZnVuY3Rpb24gKGR0T3B0aW9ucykge1xuICAgICAgICAgICAgICAgIC8vIFVzaW5nIHNldFRpbWVvdXQgYXMgYSBcImhhY2tcIiB0byBiZSBcInBhcnRcIiBvZiBOZ1pvbmVcbiAgICAgICAgICAgICAgICBzZXRUaW1lb3V0KGZ1bmN0aW9uICgpIHtcbiAgICAgICAgICAgICAgICAgICAgX3RoaXMuZHQgPSAkKF90aGlzLmVsLm5hdGl2ZUVsZW1lbnQpLkRhdGFUYWJsZShkdE9wdGlvbnMpO1xuICAgICAgICAgICAgICAgICAgICByZXNvbHZlKF90aGlzLmR0KTtcbiAgICAgICAgICAgICAgICB9KTtcbiAgICAgICAgICAgIH0pO1xuICAgICAgICB9KTtcbiAgICB9O1xuICAgIF9fZGVjb3JhdGUoW1xuICAgICAgICBJbnB1dCgpLFxuICAgICAgICBfX21ldGFkYXRhKFwiZGVzaWduOnR5cGVcIiwgT2JqZWN0KVxuICAgIF0sIERhdGFUYWJsZURpcmVjdGl2ZS5wcm90b3R5cGUsIFwiZHRPcHRpb25zXCIsIHZvaWQgMCk7XG4gICAgX19kZWNvcmF0ZShbXG4gICAgICAgIElucHV0KCksXG4gICAgICAgIF9fbWV0YWRhdGEoXCJkZXNpZ246dHlwZVwiLCBTdWJqZWN0KVxuICAgIF0sIERhdGFUYWJsZURpcmVjdGl2ZS5wcm90b3R5cGUsIFwiZHRUcmlnZ2VyXCIsIHZvaWQgMCk7XG4gICAgRGF0YVRhYmxlRGlyZWN0aXZlID0gX19kZWNvcmF0ZShbXG4gICAgICAgIERpcmVjdGl2ZSh7XG4gICAgICAgICAgICBzZWxlY3RvcjogJ1tkYXRhdGFibGVdJ1xuICAgICAgICB9KSxcbiAgICAgICAgX19tZXRhZGF0YShcImRlc2lnbjpwYXJhbXR5cGVzXCIsIFtFbGVtZW50UmVmXSlcbiAgICBdLCBEYXRhVGFibGVEaXJlY3RpdmUpO1xuICAgIHJldHVybiBEYXRhVGFibGVEaXJlY3RpdmU7XG59KCkpO1xuZXhwb3J0IHsgRGF0YVRhYmxlRGlyZWN0aXZlIH07XG4iXX0=