class ArchivedState implements DocumentState {

    @Override
    public void submit(Document doc)            { System.out.println("Document is archived."); }

    @Override
    public void review(Document doc)            { System.out.println("Document is archived."); }

    @Override
    public void approve(Document doc)           { System.out.println("Document is archived."); }

    @Override
    public void reject(Document doc, String r)  { System.out.println("Document is archived."); }

    @Override
    public void publish(Document doc)           { System.out.println("Document is archived."); }

    @Override
    public void archive(Document doc)           { System.out.println("Already archived."); }
}
