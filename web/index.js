$("#home-tab").click(function() {
	$("#faq-div").hide();
	$("#about-div").hide();
	$("#team-div").hide();
	$("#faq-tab").attr('class', '');
	$("#about-tab").attr('class', '');
	$("#home-tab").attr('class', 'active');
	$("#home-div").show();
});

$("#about-tab").click(function() {
	$("#faq-div").hide();
	$("#home-div").hide();
	$("#faq-tab").attr('class', '');
	$("#home-tab").attr('class', '');
	$("#about-tab").attr('class', 'active');
	$("#about-div").show();
	$("#team-div").show();
});

$("#faq-tab").click(function() {
	$("#about-div").hide();
	$("#home-div").hide();
	$("#team-div").hide();
	$("#home-tab").attr('class', '');
	$("#about-tab").attr('class', '');
	$("#faq-tab").attr('class', 'active');
	$("#faq-div").show();
});