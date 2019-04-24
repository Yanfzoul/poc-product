(function($) {
    $.fn.hashtaghistory = function() {
        let $instagram = this;        
        let limit = parseInt($instagram.data("limit"), 10);
		let hashtag = $instagram.data("hashtag");

        if(hashtag == "") {
            return false;
        }

        const generateHtml = function(postsObject) {
            let html = "";

            for(var i = 0; i < limit; i++) {
                if(postsObject[i] !== undefined) {
                    let post = postsObject[i].node;
                    let tempHtml = "<img src='" + post.thumbnail_resources[4].src + "' alt='" + post.accessibility_caption + "'>"
                    tempHtml = "<div class='col-xl-3 col-sm-4 insta-feed-img'> <a href='https://www.instagram.com/p/"+ post.shortcode +"'>" + tempHtml + "</a></div>";
                    html += tempHtml;
                }   
            }
            return html;
        };

        $.ajax({
            url: "https://www.instagram.com/explore/tags/" + hashtag + "/?__a=1",
            success: function(data) {
                let posts = data.graphql.hashtag.edge_hashtag_to_media.edges;
                $instagram.html(generateHtml(posts));
            }
        });
    }
})(jQuery);
