import * as ɵngcc0 from '@angular/core';
export declare abstract class TranslateParser {
    /**
     * Interpolates a string to replace parameters
     * "This is a {{ key }}" ==> "This is a value", with params = { key: "value" }
     * @param expr
     * @param params
     */
    abstract interpolate(expr: string | Function, params?: any): string;
    /**
     * Gets a value from an object by composed key
     * parser.getValue({ key1: { keyA: 'valueI' }}, 'key1.keyA') ==> 'valueI'
     * @param target
     * @param key
     */
    abstract getValue(target: any, key: string): any;
}
export declare class TranslateDefaultParser extends TranslateParser {
    templateMatcher: RegExp;
    interpolate(expr: string | Function, params?: any): string;
    getValue(target: any, key: string): any;
    private interpolateFunction;
    private interpolateString;
    static ɵfac: ɵngcc0.ɵɵFactoryDef<TranslateDefaultParser>;
    static ɵprov: ɵngcc0.ɵɵInjectableDef<TranslateDefaultParser>;
}

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoidHJhbnNsYXRlLnBhcnNlci5kLnRzIiwic291cmNlcyI6WyJ0cmFuc2xhdGUucGFyc2VyLmQudHMiXSwibmFtZXMiOltdLCJtYXBwaW5ncyI6IjtBQUFBOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUFzQkEiLCJzb3VyY2VzQ29udGVudCI6WyJleHBvcnQgZGVjbGFyZSBhYnN0cmFjdCBjbGFzcyBUcmFuc2xhdGVQYXJzZXIge1xuICAgIC8qKlxuICAgICAqIEludGVycG9sYXRlcyBhIHN0cmluZyB0byByZXBsYWNlIHBhcmFtZXRlcnNcbiAgICAgKiBcIlRoaXMgaXMgYSB7eyBrZXkgfX1cIiA9PT4gXCJUaGlzIGlzIGEgdmFsdWVcIiwgd2l0aCBwYXJhbXMgPSB7IGtleTogXCJ2YWx1ZVwiIH1cbiAgICAgKiBAcGFyYW0gZXhwclxuICAgICAqIEBwYXJhbSBwYXJhbXNcbiAgICAgKi9cbiAgICBhYnN0cmFjdCBpbnRlcnBvbGF0ZShleHByOiBzdHJpbmcgfCBGdW5jdGlvbiwgcGFyYW1zPzogYW55KTogc3RyaW5nO1xuICAgIC8qKlxuICAgICAqIEdldHMgYSB2YWx1ZSBmcm9tIGFuIG9iamVjdCBieSBjb21wb3NlZCBrZXlcbiAgICAgKiBwYXJzZXIuZ2V0VmFsdWUoeyBrZXkxOiB7IGtleUE6ICd2YWx1ZUknIH19LCAna2V5MS5rZXlBJykgPT0+ICd2YWx1ZUknXG4gICAgICogQHBhcmFtIHRhcmdldFxuICAgICAqIEBwYXJhbSBrZXlcbiAgICAgKi9cbiAgICBhYnN0cmFjdCBnZXRWYWx1ZSh0YXJnZXQ6IGFueSwga2V5OiBzdHJpbmcpOiBhbnk7XG59XG5leHBvcnQgZGVjbGFyZSBjbGFzcyBUcmFuc2xhdGVEZWZhdWx0UGFyc2VyIGV4dGVuZHMgVHJhbnNsYXRlUGFyc2VyIHtcbiAgICB0ZW1wbGF0ZU1hdGNoZXI6IFJlZ0V4cDtcbiAgICBpbnRlcnBvbGF0ZShleHByOiBzdHJpbmcgfCBGdW5jdGlvbiwgcGFyYW1zPzogYW55KTogc3RyaW5nO1xuICAgIGdldFZhbHVlKHRhcmdldDogYW55LCBrZXk6IHN0cmluZyk6IGFueTtcbiAgICBwcml2YXRlIGludGVycG9sYXRlRnVuY3Rpb247XG4gICAgcHJpdmF0ZSBpbnRlcnBvbGF0ZVN0cmluZztcbn1cbiJdfQ==