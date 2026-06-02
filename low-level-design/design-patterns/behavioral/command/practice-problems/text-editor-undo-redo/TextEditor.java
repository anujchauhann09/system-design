class TextEditor {

    private StringBuilder content = new StringBuilder();

    public void insert(String text) {
        content.append(text);
    }

    public void insertAt(int position, String text) {
        content.insert(position, text);
    }

    public String deleteLast(int length) {
        int start = Math.max(0, content.length() - length);
        String removed = content.substring(start);
        content.delete(start, content.length());
        return removed;
    }

    public int length() {
        return content.length();
    }

    public String getContent() {
        return content.toString();
    }
}
