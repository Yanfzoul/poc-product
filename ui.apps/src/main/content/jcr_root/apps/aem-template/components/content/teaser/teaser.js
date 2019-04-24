use(function() {
    var mode = properties.get('mode', 'static');
    var teaser;

    var bgColor, mainColor;
    var wrapperStyles = [];
    var teaserStyles = [];

    var backgroundClass = properties.get('backgroundColorClass');
    var mainClass = properties.get('mainColorClass');

    if(backgroundClass == 'bw-custom') {
        bgColor = properties.get('backgroundColor', 'transparent');
        teaserStyles.push('background-color: ' + bgColor);
    }
    if(mainClass == 'bw-custom') {
        mainColor = properties.get('mainColor', 'inherit');
        teaserStyles.push('color: ' + mainColor);
    }

    var paddingTop      = properties.get('paddingTop', '0');
    var paddingRight    = properties.get('paddingRight', '0');
    var paddingBottom   = properties.get('paddingBottom', '0');
    var paddingLeft     = properties.get('paddingLeft', '0');

    wrapperStyles.push('padding: ' + [paddingTop, paddingRight, paddingBottom, paddingLeft].join(' '))

    return {
        wrapperStyles:  wrapperStyles.join('; '),
        teaserStyles:     teaserStyles.join('; '),
        teaser:			teaser
    }
});