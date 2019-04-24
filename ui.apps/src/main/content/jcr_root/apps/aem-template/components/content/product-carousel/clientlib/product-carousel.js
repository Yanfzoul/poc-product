$(function () {
    $('.product-slider').owlCarousel({
        loop: false,
        margin: 0,
        nav: false,
        dots: true,

        smartSpeed: 400,
        responsiveClass: true,
        responsive: {
            0: {
                items: 1
            },
            600: {
                items: 3
            },
            1000: {
                items: 5
            }
        }
    });
});