- FrameLayout の中にいる ImageView を FrameLayout の範囲外にも描画しつつ、他の FrameLayout の上にも描画したい。
- bringToFront() すれば FrameLayout ごと最前面に持ってこれる。
- ListView のように ListItem(FrameLayout) が隣接していると、どれかが最前面に来るとそれによって他の ListItem(FrameLayout) が後ろに来て中身の ImageView が隠れてしまう。
- ListView の divider 上に被るように ImageView を載せようとすると最前面でない ListItem(FrameLayout) ではより上位の ListItem(FrameLayout) に上書きされてしまう。
- つらい。

<blockquote class="twitter-tweet" lang="ja"><p lang="ja" dir="ltr">濃い緑と薄い緑のセットで１行。&#10;１行目と２行目の境目にいるDroid君（右から３番目）は２行目の描画時に overdraw されて clip されてしまう。助けて <a href="http://t.co/95RBNS8iw9">pic.twitter.com/95RBNS8iw9</a></p>&mdash; イカ@wada811 (@wada811) <a href="https://twitter.com/wada811/status/618709730458873856">2015, 7月 8</a></blockquote>
<script async src="//platform.twitter.com/widgets.js" charset="utf-8"></script>

[![https://pbs.twimg.com/media/CJYZKHzVAAAXy_x.png](https://pbs.twimg.com/media/CJYZKHzVAAAXy_x.png)]
