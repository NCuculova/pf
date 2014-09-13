'use strict';

/**
 * The services map method to the adequate RestController
 */

angular.module('PF.services', []);

PF.factory('Search', ['$resource', function($resource) {
  return $resource(PFUtil.ctx('/data/rest/search/:id'), {}, {
    'search': {
      method: 'GET',
      isArray: true,
      url: PFUtil.ctx('/data/rest/search/:keywords')
    }
  });
}]);

PF.factory('Symptom', ['$resource', function($resource) {
	  return $resource(PFUtil.ctx('/data/rest/symptom/:id'), {}, {
	  });
	}]);