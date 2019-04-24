use(function() {
    var mode = properties.get('mode', 'static');
    var image;

    var wrapperStyles = [];

    var paddingTop      = properties.get('paddingTop', '0');
    var paddingRight    = properties.get('paddingRight', '0');
    var paddingBottom   = properties.get('paddingBottom', '0');
    var paddingLeft     = properties.get('paddingLeft', '0');

    wrapperStyles.push('padding: ' + [paddingTop, paddingRight, paddingBottom, paddingLeft].join(' '))

    return {
        wrapperStyles:  wrapperStyles.join('; '),
        image:			image
    }
});