import { AfterViewChecked, ChangeDetectorRef, ElementRef, OnDestroy } from '@angular/core';
import { Subscription } from 'rxjs';
import { TranslateService } from './translate.service';
import * as ɵngcc0 from '@angular/core';
export declare class TranslateDirective implements AfterViewChecked, OnDestroy {
    private translateService;
    private element;
    private _ref;
    key: string;
    lastParams: any;
    currentParams: any;
    onLangChangeSub: Subscription;
    onDefaultLangChangeSub: Subscription;
    onTranslationChangeSub: Subscription;
    translate: string;
    translateParams: any;
    constructor(translateService: TranslateService, element: ElementRef, _ref: ChangeDetectorRef);
    ngAfterViewChecked(): void;
    checkNodes(forceUpdate?: boolean, translations?: any): void;
    updateValue(key: string, node: any, translations: any): void;
    getContent(node: any): string;
    setContent(node: any, content: string): void;
    ngOnDestroy(): void;
    static ɵfac: ɵngcc0.ɵɵFactoryDef<TranslateDirective>;
    static ɵdir: ɵngcc0.ɵɵDirectiveDefWithMeta<TranslateDirective, "[translate],[ngx-translate]", never, {
    "translate": "translate";
    "translateParams": "translateParams";
}, {}, never>;
}

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoidHJhbnNsYXRlLmRpcmVjdGl2ZS5kLnRzIiwic291cmNlcyI6WyJ0cmFuc2xhdGUuZGlyZWN0aXZlLmQudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IkFBQUE7Ozs7QUFHQTs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7O0FBbUJBIiwic291cmNlc0NvbnRlbnQiOlsiaW1wb3J0IHsgQWZ0ZXJWaWV3Q2hlY2tlZCwgQ2hhbmdlRGV0ZWN0b3JSZWYsIEVsZW1lbnRSZWYsIE9uRGVzdHJveSB9IGZyb20gJ0Bhbmd1bGFyL2NvcmUnO1xuaW1wb3J0IHsgU3Vic2NyaXB0aW9uIH0gZnJvbSAncnhqcyc7XG5pbXBvcnQgeyBUcmFuc2xhdGVTZXJ2aWNlIH0gZnJvbSAnLi90cmFuc2xhdGUuc2VydmljZSc7XG5leHBvcnQgZGVjbGFyZSBjbGFzcyBUcmFuc2xhdGVEaXJlY3RpdmUgaW1wbGVtZW50cyBBZnRlclZpZXdDaGVja2VkLCBPbkRlc3Ryb3kge1xuICAgIHByaXZhdGUgdHJhbnNsYXRlU2VydmljZTtcbiAgICBwcml2YXRlIGVsZW1lbnQ7XG4gICAgcHJpdmF0ZSBfcmVmO1xuICAgIGtleTogc3RyaW5nO1xuICAgIGxhc3RQYXJhbXM6IGFueTtcbiAgICBjdXJyZW50UGFyYW1zOiBhbnk7XG4gICAgb25MYW5nQ2hhbmdlU3ViOiBTdWJzY3JpcHRpb247XG4gICAgb25EZWZhdWx0TGFuZ0NoYW5nZVN1YjogU3Vic2NyaXB0aW9uO1xuICAgIG9uVHJhbnNsYXRpb25DaGFuZ2VTdWI6IFN1YnNjcmlwdGlvbjtcbiAgICB0cmFuc2xhdGU6IHN0cmluZztcbiAgICB0cmFuc2xhdGVQYXJhbXM6IGFueTtcbiAgICBjb25zdHJ1Y3Rvcih0cmFuc2xhdGVTZXJ2aWNlOiBUcmFuc2xhdGVTZXJ2aWNlLCBlbGVtZW50OiBFbGVtZW50UmVmLCBfcmVmOiBDaGFuZ2VEZXRlY3RvclJlZik7XG4gICAgbmdBZnRlclZpZXdDaGVja2VkKCk6IHZvaWQ7XG4gICAgY2hlY2tOb2Rlcyhmb3JjZVVwZGF0ZT86IGJvb2xlYW4sIHRyYW5zbGF0aW9ucz86IGFueSk6IHZvaWQ7XG4gICAgdXBkYXRlVmFsdWUoa2V5OiBzdHJpbmcsIG5vZGU6IGFueSwgdHJhbnNsYXRpb25zOiBhbnkpOiB2b2lkO1xuICAgIGdldENvbnRlbnQobm9kZTogYW55KTogc3RyaW5nO1xuICAgIHNldENvbnRlbnQobm9kZTogYW55LCBjb250ZW50OiBzdHJpbmcpOiB2b2lkO1xuICAgIG5nT25EZXN0cm95KCk6IHZvaWQ7XG59XG4iXX0=