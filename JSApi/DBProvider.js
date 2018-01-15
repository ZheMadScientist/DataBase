class DBProvider {
  constructor(uri) {
    this.url = uri;
  }
  function getItem() {
    var xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", this.url, false );
    xmlHttp.send( null );
    return xmlHttp.responseText;
  }

}
