function loadNotifications() {

	this.source = null;

	this.start = function() {

		var notificationTable = document.getElementById("notifications");

		const channelIdValue = new URLSearchParams(window.location.search).get('channelId');
		
		this.source = new EventSource("/messages?channelId="+channelIdValue);

		this.source.addEventListener("message", function(event) {

			var notification = JSON.parse(event.data);

			var row = notificationTable.getElementsByTagName("tbody")[0]
					.insertRow(0);
			var cell0 = row.insertCell(0);
			var cell1 = row.insertCell(1);
			var cell2 = row.insertCell(2);

			cell0.className = "author-style";
			cell0.innerHTML = notification.sender;

			cell1.className = "text";
			cell1.innerHTML = notification.receiver;

			cell2.className = "author-style";
			cell2.innerHTML = notification.message;

		});

		this.source.onerror = function() {
			this.close();
		};

	};

	this.stop = function() {
		this.source.close();
	}

}

notification = new loadNotifications();

window.onload = function() {
	notification.start();
};
window.onbeforeunload = function() {
	notification.stop();
}