/*GDPR rating */
enum InitConsentSet {
  initConsentSetUnknown,
  initConsentSetPersonalized,
  initConsentSetNonpersonalized
}

/*User location */
enum InitUserLocation {
  initUserLocationUnknown,
  initUserLocationInEU,
  initUserLocationOutOfEU
}

class ATInitResponse {
  final consentSet;
  final userLocation;
  final consentDismiss;

  ATInitResponse(this.consentSet, this.userLocation, this.consentDismiss);

  factory ATInitResponse.withMap(Map map) {
    var tempConsentSet;

    var tempUserLocation;

    var tempConsentDismiss;

    if (map.containsKey('location')) {
      if (map['location'] == '1') {
        tempUserLocation = InitUserLocation.initUserLocationInEU;
      } else if (map['location'] == '2') {
        tempUserLocation = InitUserLocation.initUserLocationOutOfEU;
      } else {
        tempUserLocation = InitUserLocation.initUserLocationUnknown;
      }
    } else {
      tempUserLocation = null;
    }

    if (map.containsKey('consentSet')) {
      if (map['consentSet'] == '1') {
        tempConsentSet = InitConsentSet.initConsentSetPersonalized;
      } else if (map['consentSet'] == '2') {
        tempConsentSet = InitConsentSet.initConsentSetNonpersonalized;
      } else {
        tempConsentSet = InitConsentSet.initConsentSetUnknown;
      }
    } else {
      tempConsentSet = null;
    }

    if (map.containsKey('consentDismiss')) {
      tempConsentDismiss = map['consentDismiss'];
    } else {
      tempConsentDismiss = null;
    }

    return ATInitResponse(tempConsentSet, tempUserLocation, tempConsentDismiss);
  }
}
