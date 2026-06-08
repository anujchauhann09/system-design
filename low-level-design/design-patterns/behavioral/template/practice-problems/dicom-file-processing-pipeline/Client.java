public class Client {

    public static void main(String args[]) {

        DicomProcessor ct = new CtProcessor();
        ct.process();

        System.out.println();

        DicomProcessor mri = new MriProcessor();
        mri.process();

        System.out.println();

        DicomProcessor ultrasound = new UltrasoundProcessor();
        ultrasound.process();
    }
}
