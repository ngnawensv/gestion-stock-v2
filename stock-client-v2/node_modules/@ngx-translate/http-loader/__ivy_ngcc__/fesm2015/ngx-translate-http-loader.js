/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,missingReturn,uselessCode} checked by tsc
 */
class TranslateHttpLoader {
    /**
     * @param {?} http
     * @param {?=} prefix
     * @param {?=} suffix
     */
    constructor(http, prefix = "/assets/i18n/", suffix = ".json") {
        this.http = http;
        this.prefix = prefix;
        this.suffix = suffix;
    }
    /**
     * Gets the translations from the server
     * @param {?} lang
     * @return {?}
     */
    getTranslation(lang) {
        return this.http.get(`${this.prefix}${lang}${this.suffix}`);
    }
}

/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,missingReturn,uselessCode} checked by tsc
 */

/**
 * @fileoverview added by tsickle
 * @suppress {checkTypes,extraRequire,missingReturn,uselessCode} checked by tsc
 */

export { TranslateHttpLoader };

//# sourceMappingURL=data:application/json;charset=utf-8;base64,eyJ2ZXJzaW9uIjozLCJmaWxlIjoibmd4LXRyYW5zbGF0ZS1odHRwLWxvYWRlci5qcyIsInNvdXJjZXMiOlsibmc6L0BuZ3gtdHJhbnNsYXRlL2h0dHAtbG9hZGVyL2xpYi9odHRwLWxvYWRlci50cyJdLCJuYW1lcyI6W10sIm1hcHBpbmdzIjoiOzs7O0FBSUEsTUFBYSxtQkFBbUI7Ozs7OztJQUM5QixZQUFvQixJQUFnQixFQUFTLFNBQWlCLGVBQWUsRUFBUyxTQUFpQixPQUFPO1FBQTFGLFNBQUksR0FBSixJQUFJLENBQVk7UUFBUyxXQUFNLEdBQU4sTUFBTSxDQUEwQjtRQUFTLFdBQU0sR0FBTixNQUFNLENBQWtCO0tBQUk7Ozs7OztJQUszRyxjQUFjLENBQUMsSUFBWTtRQUNoQyxPQUFPLElBQUksQ0FBQyxJQUFJLENBQUMsR0FBRyxDQUFDLEdBQUcsSUFBSSxDQUFDLE1BQU0sR0FBRyxJQUFJLEdBQUcsSUFBSSxDQUFDLE1BQU0sRUFBRSxDQUFDLENBQUM7S0FDN0Q7Q0FDRiIsInNvdXJjZXNDb250ZW50IjpbImltcG9ydCB7SHR0cENsaWVudH0gZnJvbSBcIkBhbmd1bGFyL2NvbW1vbi9odHRwXCI7XG5pbXBvcnQge1RyYW5zbGF0ZUxvYWRlcn0gZnJvbSBcIkBuZ3gtdHJhbnNsYXRlL2NvcmVcIjtcbmltcG9ydCB7T2JzZXJ2YWJsZX0gZnJvbSAncnhqcyc7XG5cbmV4cG9ydCBjbGFzcyBUcmFuc2xhdGVIdHRwTG9hZGVyIGltcGxlbWVudHMgVHJhbnNsYXRlTG9hZGVyIHtcbiAgY29uc3RydWN0b3IocHJpdmF0ZSBodHRwOiBIdHRwQ2xpZW50LCBwdWJsaWMgcHJlZml4OiBzdHJpbmcgPSBcIi9hc3NldHMvaTE4bi9cIiwgcHVibGljIHN1ZmZpeDogc3RyaW5nID0gXCIuanNvblwiKSB7fVxuXG4gIC8qKlxuICAgKiBHZXRzIHRoZSB0cmFuc2xhdGlvbnMgZnJvbSB0aGUgc2VydmVyXG4gICAqL1xuICBwdWJsaWMgZ2V0VHJhbnNsYXRpb24obGFuZzogc3RyaW5nKTogT2JzZXJ2YWJsZTxPYmplY3Q+IHtcbiAgICByZXR1cm4gdGhpcy5odHRwLmdldChgJHt0aGlzLnByZWZpeH0ke2xhbmd9JHt0aGlzLnN1ZmZpeH1gKTtcbiAgfVxufVxuIl19