import { TranslateService } from "./translate.service";
import * as ɵngcc0 from '@angular/core';
export interface MissingTranslationHandlerParams {
    /**
     * the key that's missing in translation files
     */
    key: string;
    /**
     * an instance of the service that was unable to translate the key.
     */
    translateService: TranslateService;
    /**
     * interpolation params that were passed along for translating the given key.
     */
    interpolateParams?: Object;
}
export declare abstract class MissingTranslationHandler {
    /**
     * A function that handles missing translations.
     *
     * @param params context for resolving a missing translation
     * @returns a value or an observable
     * If it returns a value, then this value is used.
     * If it return an observable, the value returned by this observable will be used (except if the method was "instant").
     * If it doesn't return then the key will be used as a value
     */
    abstract handle(params: MissingTranslationHandlerParams): any;
}
/**
 * This handler is just a placeholder that does nothing, in case you don't need a missing translation handler at all
 */
export declare class FakeMissingTranslationHandler implements MissingTranslationHandler {
    handle(params: MissingTranslationHandlerParams): string;
    static ɵfac: ɵngcc0.ɵɵFactoryDef<FakeMissingTranslationHandler>;
    static ɵprov: ɵngcc0.ɵɵInjectableDef<FakeMissingTranslationHandler>;
}

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibWlzc2luZy10cmFuc2xhdGlvbi1oYW5kbGVyLmQudHMiLCJzb3VyY2VzIjpbIm1pc3NpbmctdHJhbnNsYXRpb24taGFuZGxlci5kLnRzIl0sIm5hbWVzIjpbXSwibWFwcGluZ3MiOiJBQUFBOztBQUNBOzs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7Ozs7QUErQkEiLCJzb3VyY2VzQ29udGVudCI6WyJpbXBvcnQgeyBUcmFuc2xhdGVTZXJ2aWNlIH0gZnJvbSBcIi4vdHJhbnNsYXRlLnNlcnZpY2VcIjtcbmV4cG9ydCBpbnRlcmZhY2UgTWlzc2luZ1RyYW5zbGF0aW9uSGFuZGxlclBhcmFtcyB7XG4gICAgLyoqXG4gICAgICogdGhlIGtleSB0aGF0J3MgbWlzc2luZyBpbiB0cmFuc2xhdGlvbiBmaWxlc1xuICAgICAqL1xuICAgIGtleTogc3RyaW5nO1xuICAgIC8qKlxuICAgICAqIGFuIGluc3RhbmNlIG9mIHRoZSBzZXJ2aWNlIHRoYXQgd2FzIHVuYWJsZSB0byB0cmFuc2xhdGUgdGhlIGtleS5cbiAgICAgKi9cbiAgICB0cmFuc2xhdGVTZXJ2aWNlOiBUcmFuc2xhdGVTZXJ2aWNlO1xuICAgIC8qKlxuICAgICAqIGludGVycG9sYXRpb24gcGFyYW1zIHRoYXQgd2VyZSBwYXNzZWQgYWxvbmcgZm9yIHRyYW5zbGF0aW5nIHRoZSBnaXZlbiBrZXkuXG4gICAgICovXG4gICAgaW50ZXJwb2xhdGVQYXJhbXM/OiBPYmplY3Q7XG59XG5leHBvcnQgZGVjbGFyZSBhYnN0cmFjdCBjbGFzcyBNaXNzaW5nVHJhbnNsYXRpb25IYW5kbGVyIHtcbiAgICAvKipcbiAgICAgKiBBIGZ1bmN0aW9uIHRoYXQgaGFuZGxlcyBtaXNzaW5nIHRyYW5zbGF0aW9ucy5cbiAgICAgKlxuICAgICAqIEBwYXJhbSBwYXJhbXMgY29udGV4dCBmb3IgcmVzb2x2aW5nIGEgbWlzc2luZyB0cmFuc2xhdGlvblxuICAgICAqIEByZXR1cm5zIGEgdmFsdWUgb3IgYW4gb2JzZXJ2YWJsZVxuICAgICAqIElmIGl0IHJldHVybnMgYSB2YWx1ZSwgdGhlbiB0aGlzIHZhbHVlIGlzIHVzZWQuXG4gICAgICogSWYgaXQgcmV0dXJuIGFuIG9ic2VydmFibGUsIHRoZSB2YWx1ZSByZXR1cm5lZCBieSB0aGlzIG9ic2VydmFibGUgd2lsbCBiZSB1c2VkIChleGNlcHQgaWYgdGhlIG1ldGhvZCB3YXMgXCJpbnN0YW50XCIpLlxuICAgICAqIElmIGl0IGRvZXNuJ3QgcmV0dXJuIHRoZW4gdGhlIGtleSB3aWxsIGJlIHVzZWQgYXMgYSB2YWx1ZVxuICAgICAqL1xuICAgIGFic3RyYWN0IGhhbmRsZShwYXJhbXM6IE1pc3NpbmdUcmFuc2xhdGlvbkhhbmRsZXJQYXJhbXMpOiBhbnk7XG59XG4vKipcbiAqIFRoaXMgaGFuZGxlciBpcyBqdXN0IGEgcGxhY2Vob2xkZXIgdGhhdCBkb2VzIG5vdGhpbmcsIGluIGNhc2UgeW91IGRvbid0IG5lZWQgYSBtaXNzaW5nIHRyYW5zbGF0aW9uIGhhbmRsZXIgYXQgYWxsXG4gKi9cbmV4cG9ydCBkZWNsYXJlIGNsYXNzIEZha2VNaXNzaW5nVHJhbnNsYXRpb25IYW5kbGVyIGltcGxlbWVudHMgTWlzc2luZ1RyYW5zbGF0aW9uSGFuZGxlciB7XG4gICAgaGFuZGxlKHBhcmFtczogTWlzc2luZ1RyYW5zbGF0aW9uSGFuZGxlclBhcmFtcyk6IHN0cmluZztcbn1cbiJdfQ==