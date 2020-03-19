/*---------- HTML태그제거 : removeHTML func ----------*/
function removeHTML (text) {
	text = text.replace(/<br\/>/ig, "\n");
	text = text.replace(/<(\/)?([a-zA-Z]*)(\s[a-zA-Z]*=[^>]*)?(\s)*(\/)?>/ig, "");
	return text;
}
