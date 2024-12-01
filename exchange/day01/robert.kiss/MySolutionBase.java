import javax.swing.*;
import java.awt.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


abstract class MySolutionBase {
    String inputFilename;
    Path inputPath;
    List<String> inputLines;

    public MySolutionBase(String inputFilename) {
        System.out.println("\n\n*** INPUT : "+inputFilename);
        try {
            this.inputFilename = inputFilename;
            this.inputPath= Paths.get(MySolutionBase.class.getClassLoader().getResource(this.inputFilename).toURI());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Stream<String> getInputLinesAsStream() {
        try {
            return Files.lines(this.inputPath);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return Stream.of(new String[0]);
        }
    }


    public List<String> getInputLinesAsList() {
        if (this.inputLines==null) {
            this.inputLines = this.getInputLinesAsStream().collect(Collectors.toList());
        }
        return this.inputLines;
    }

    public MySolutionBase play1() {
        System.out.println("   *** TASK 1");
        solve1();
        return this;
    }


    public MySolutionBase play2() {
        System.out.println("   *** TASK 2");
        solve2();
        return this;
    }

    protected abstract void solve1();
    protected abstract void solve2();

    public void pln(Object o) {
        System.out.println("      "+o);
    }
    public void pln() {
        System.out.println();
    }
    public void plnf(String format, Object... args) {
        System.out.printf("      "+(format) + "%n", args);
    }

    static JFrame jf = null;
    static JTextArea jArea = null;
    public void pJFrame(String s){
        if (jf == null) {
            jf = new JFrame();
            jArea = new JTextArea();
            jArea.setBounds(10, 30, 1200, 1400);
            jArea.setFont(new Font("Courier New", Font.PLAIN, 9));
            jf.add(jArea);
            jf.setSize(1200, 1350);
            jf.setLayout(null);
            jf.setVisible(true);
        }
        jArea.setText(s);
    }


}
