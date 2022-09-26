
//let coords = {lat: 33.1581, lng: -117.3506};

function initMap() {
	let image = {url: '/marker.png', scaledSize:new google.maps.Size(60,60)};
    let map = new google.maps.Map(document.getElementById('map'), {
          center: coords,
          zoom: 15,
          scrollwheel:false
        });
        let marker = new google.maps.Marker({
			position: coords,
			map: map,
			icon: image,
			animation: google.maps.Animation.BOUNCE
			});
			
let contentString = '<h2>' + city + ', ' + state + '</h2>';

let infowindow = new google.maps.InfoWindow({
   content: contentString
 });

 google.maps.event.addListener(marker, 'click', function() {
    infowindow.open(map,marker);
 });
		
}
      