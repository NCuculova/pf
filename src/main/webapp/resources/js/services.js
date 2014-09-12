'use strict';

/**
 * The services map method to the adequate RestController
 */

angular.module('PF.services', []);

PF.factory('Sample', ['$resource', function($resource) {
  return $resource(PFUtil.ctx('/data/rest/members/:id'), {}, {
    'login': {
      method: 'POST',
      url: PFUtil.ctx('/data/rest/members/login')
    },
    'auth': {
      method: 'POST',
      url: PFUtil.ctx('/data/rest/members/auth')
    }
  });
}]);