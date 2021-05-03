import { ChangeDetectorRef, OnDestroy, PipeTransform } from '@angular/core';
import { TranslateService } from './translate.service';
import { Subscription } from 'rxjs';
import * as ɵngcc0 from '@angular/core';
export declare class TranslatePipe implements PipeTransform, OnDestroy {
    private translate;
    private _ref;
    value: string;
    lastKey: string;
    lastParams: any[];
    onTranslationChange: Subscription;
    onLangChange: Subscription;
    onDefaultLangChange: Subscription;
    constructor(translate: TranslateService, _ref: ChangeDetectorRef);
    updateValue(key: string, interpolateParams?: Object, translations?: any): void;
    transform(query: string, ...args: any[]): any;
    /**
     * Clean any existing subscription to change events
     */
    private _dispose;
    ngOnDestroy(): void;
    static ɵfac: ɵngcc0.ɵɵFactoryDef<TranslatePipe>;
    static ɵpipe: ɵngcc0.ɵɵPipeDefWithMeta<TranslatePipe, "translate">;
    static ɵprov: ɵngcc0.ɵɵInjectableDef<TranslatePipe>;
}

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoidHJhbnNsYXRlLnBpcGUuZC50cyIsInNvdXJjZXMiOlsidHJhbnNsYXRlLnBpcGUuZC50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiQUFBQTs7OztBQUdBOzs7Ozs7Ozs7Ozs7Ozs7Ozs7OztBQWlCQSIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7IENoYW5nZURldGVjdG9yUmVmLCBPbkRlc3Ryb3ksIFBpcGVUcmFuc2Zvcm0gfSBmcm9tICdAYW5ndWxhci9jb3JlJztcbmltcG9ydCB7IFRyYW5zbGF0ZVNlcnZpY2UgfSBmcm9tICcuL3RyYW5zbGF0ZS5zZXJ2aWNlJztcbmltcG9ydCB7IFN1YnNjcmlwdGlvbiB9IGZyb20gJ3J4anMnO1xuZXhwb3J0IGRlY2xhcmUgY2xhc3MgVHJhbnNsYXRlUGlwZSBpbXBsZW1lbnRzIFBpcGVUcmFuc2Zvcm0sIE9uRGVzdHJveSB7XG4gICAgcHJpdmF0ZSB0cmFuc2xhdGU7XG4gICAgcHJpdmF0ZSBfcmVmO1xuICAgIHZhbHVlOiBzdHJpbmc7XG4gICAgbGFzdEtleTogc3RyaW5nO1xuICAgIGxhc3RQYXJhbXM6IGFueVtdO1xuICAgIG9uVHJhbnNsYXRpb25DaGFuZ2U6IFN1YnNjcmlwdGlvbjtcbiAgICBvbkxhbmdDaGFuZ2U6IFN1YnNjcmlwdGlvbjtcbiAgICBvbkRlZmF1bHRMYW5nQ2hhbmdlOiBTdWJzY3JpcHRpb247XG4gICAgY29uc3RydWN0b3IodHJhbnNsYXRlOiBUcmFuc2xhdGVTZXJ2aWNlLCBfcmVmOiBDaGFuZ2VEZXRlY3RvclJlZik7XG4gICAgdXBkYXRlVmFsdWUoa2V5OiBzdHJpbmcsIGludGVycG9sYXRlUGFyYW1zPzogT2JqZWN0LCB0cmFuc2xhdGlvbnM/OiBhbnkpOiB2b2lkO1xuICAgIHRyYW5zZm9ybShxdWVyeTogc3RyaW5nLCAuLi5hcmdzOiBhbnlbXSk6IGFueTtcbiAgICAvKipcbiAgICAgKiBDbGVhbiBhbnkgZXhpc3Rpbmcgc3Vic2NyaXB0aW9uIHRvIGNoYW5nZSBldmVudHNcbiAgICAgKi9cbiAgICBwcml2YXRlIF9kaXNwb3NlO1xuICAgIG5nT25EZXN0cm95KCk6IHZvaWQ7XG59XG4iXX0=