import { TestBed } from '@angular/core/testing';

import { TranslationItemService } from './translation-item.service';

describe('TranslationItemService', () => {
  let service: TranslationItemService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TranslationItemService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
