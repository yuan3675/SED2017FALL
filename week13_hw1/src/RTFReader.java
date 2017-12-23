public class RTFReader {
    private TextConverter textConverter = null;
    public void convert(String content) {
        for (Character token : content.toCharArray()) {
            if (token.equals('C')) {
                textConverter.convertC();
            }
            else if (token.equals('F')) {
                textConverter.convertF();
            }
            else if (token.equals('P')) {
                textConverter.convertP();
            }
        }
        textConverter.getConvertedTextFormat();
    }
    public void setTextConverter(String type) {
        if (type.equals("TeX")) {
            this.textConverter = new TeXConverter();
        }
        else if (type.equals("TextWidget")) {
            this.textConverter = new TextWidgetConverter();
        }
    }
}
