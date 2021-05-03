import {HttpClient} from '@angular/common/http';
import {TranslateService} from '@ngx-translate/core';
import {forkJoin, of} from 'rxjs';
import {catchError} from 'rxjs/operators';

/**
 * This fonction is use  to make translation from a language to another
 * @param http
 * @param translate
 */
export function initApp(http: HttpClient, translate: TranslateService) {
  return () => new Promise<boolean>((resolve: (res: boolean) => void) => {

    const defaultLocale = 'fr';
    const translationsUrl = '/assets/i18n/translations/';
    const sufix = '.json';
    const storageLocale = localStorage.getItem('locale');
    const locale = storageLocale || defaultLocale;

    forkJoin([
      http.get('/assets/i18n/dev.json').pipe(catchError(() => of(null))),
      http.get(translationsUrl+locale+sufix).pipe(catchError(() => of(null)))
    ]).subscribe((response: any[]) => {
      const devKeys = response[0];
      const translatedKeys = response[1];

      translate.setTranslation(defaultLocale, devKeys || {});
      translate.setTranslation(locale, translatedKeys || {}, true);

      translate.setDefaultLang(defaultLocale);
      translate.use(locale);

      resolve(true);
    });
  });
}
