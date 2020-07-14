// interaction du menu déroulant
$(document).ready(function() {
    $('#menuButton').click(function() {
        $('#mainNav').stop(true, true).slideToggle()
    })
})