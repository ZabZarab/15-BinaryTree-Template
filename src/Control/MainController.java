package Control;

import Model.BinaryTree;
import View.DrawingPanel;
import View.TreeView.TreeNode;
import View.TreeView.TreePath;

import java.sql.SQLOutput;

/**
 * Created by Jean-Pierre on 12.01.2017.
 */
public class MainController {

    private BinaryTree<String> binaryTree;

    public MainController(){
        binaryTree = new BinaryTree<>(""); // Ein Baum ohne Wurzel-Inhalt ist auf dauer ein leerer Baum - es lassen sich laut Dokumentation nichtmal Bäume anhängen. Also wird die Wurzel gefüllt.
        createMorseTree();
    }

    /**
     * Zur Präsentation des Programms wird der Morsecode im Baum dargestellt.
     */
    private void createMorseTree(){
        //TODO 02: Vervollständige den Morsebaum. Such bei google nach "morsecode as tree" als Vorlage. Das hilft, die Übersicht zu wahren.
        BinaryTree<String> left = new BinaryTree<>("E");BinaryTree<String> i = new BinaryTree<>("I");BinaryTree<String> s = new BinaryTree<>("S");BinaryTree<String> h = new BinaryTree<>("H");BinaryTree<String> v = new BinaryTree<>("V");BinaryTree<String> u = new BinaryTree<>("U");BinaryTree<String> f = new BinaryTree<>("F");BinaryTree<String> a = new BinaryTree<>("A");BinaryTree<String> r = new BinaryTree<>("R");BinaryTree<String> l = new BinaryTree<>("L");BinaryTree<String> w = new BinaryTree<>("W");BinaryTree<String> p = new BinaryTree<>("P");BinaryTree<String> j = new BinaryTree<>("J");BinaryTree<String> right = new BinaryTree<>("T");BinaryTree<String> n = new BinaryTree<>("N");BinaryTree<String> d = new BinaryTree<>("D");BinaryTree<String> k = new BinaryTree<>("K");BinaryTree<String> b = new BinaryTree<>("B");BinaryTree<String> x = new BinaryTree<>("X");BinaryTree<String> c = new BinaryTree<>("C");BinaryTree<String> y = new BinaryTree<>("Y");BinaryTree<String> m = new BinaryTree<>("M");BinaryTree<String> g = new BinaryTree<>("G");BinaryTree<String> z = new BinaryTree<>("Z");BinaryTree<String> q = new BinaryTree<>("Q");BinaryTree<String> o = new BinaryTree<>("O");

        binaryTree.setLeftTree(left);left.setLeftTree(i);i.setLeftTree(s);s.setLeftTree(h);s.setRightTree(v);i.setRightTree(u);u.setLeftTree(f);left.setRightTree(a);a.setLeftTree(r);r.setLeftTree(l);a.setRightTree(w);w.setLeftTree(p);w.setRightTree(j);

        binaryTree.setRightTree(right);right.setLeftTree(n);n.setLeftTree(d);d.setLeftTree(b);d.setRightTree(x);n.setRightTree(k);k.setLeftTree(c);k.setRightTree(y);right.setRightTree(m);m.setLeftTree(g);g.setLeftTree(z);g.setRightTree(q);m.setRightTree(o);
    }

    /**
     * Der Baum wird im übergebenem Panel dargestellt.
     * Dazu wird zunächst die alte Zeichnung entfernt.
     * Im Anschluss wird eine eine internete Hilfsmethode aufgerufen.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     */
    public void showTree(DrawingPanel panel){
        panel.removeAllObjects();
        //Der Baum wird in der Mitte des Panels beginnend gezeichnet: x = panel.getWidth()/2
        //Der linke und rechte Knoten in Tiefe 1 sind jeweils ein Viertel der Breite des Panels entfernt: spaceToTheSide = panel.getWidth()/4
        showTree(binaryTree, panel, panel.getWidth()/2, 50, panel.getWidth()/4);
		
	//Aufruf fordert das Panel zur Aktualisierung auf.
	panel.repaint();
    }

    /**
     * Hilfsmethode zum Zeichnen des Baums.
     * Für jeden Knoten wird ein neues TreeNode-Objekt dem panel hinzugefügt.
     * Für jede Kante wird ein neues TreePath-Pbjekt dem panel hinzugefügt.
     * @param tree Der zu zeichnende (Teil)Binärbaum.
     * @param panel Das DrawingPanel-Objekt, auf dem gezeichnet wird.
     * @param startX x-Koordinate seiner Wurzel
     * @param startY y-Koordinate seiner Wurzel
     * @param spaceToTheSide Gibt an, wie weit horizontal entfernt die folgenden Bäume gezeichnet werden soll.
     */
    private void showTree(BinaryTree tree, DrawingPanel panel, double startX, double startY, double spaceToTheSide) {
        //TODO 03: Vervollständige diese Methode. Aktuell wird nur der Wurzelknoten gezeichnet.
        if (!tree.isEmpty()) {
            TreeNode node = new TreeNode(startX, startY, 10, tree.getContent().toString(), false);
            panel.addObject(node);
            if(!tree.getLeftTree().isEmpty()){
                showTree(tree.getLeftTree() , panel ,startX-spaceToTheSide , startY + 60 , spaceToTheSide/2);
                TreePath leftPath = new TreePath(startX , startY, startX-spaceToTheSide, startY + 40, 2 , false );
                panel.addObject(leftPath);
            }
            if(!tree.getRightTree().isEmpty()){
                showTree(tree.getRightTree() , panel ,startX+spaceToTheSide , startY + 60 , spaceToTheSide/2);
                TreePath rightPath = new TreePath(startX , startY, startX+spaceToTheSide, startY + 40, 2 , false );
                panel.addObject(rightPath);
            }
        }
		
		
		
    }

    /**
     * Es wird das Ergebnis einer Traversierung bestimmt.
     * Ruft dazu eine interne Hilfsmethode auf.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    public String traverse(){
        return traverse(binaryTree);
    }

    /**
     * Interne hilfsmethode zur Traversierung.
     * @param tree Der zu traversierende Binärbaum.
     * @return Das Ergebnis der Traversierung als Zeichenkette.
     */
    private String traverse(BinaryTree tree){
        //TODO 04: Nachdem wir geklärt haben, was eine Traversierung ist, muss diese Methode noch vervollständigt werden. Sollte ein Kinderspiel sein.

        // Inorder:

        String output = "";
       if(!tree.getLeftTree().isEmpty()){
           output += traverse(tree.getLeftTree());
        }
       output += tree.getContent().toString();
        if(!tree.getRightTree().isEmpty()){
            output += traverse(tree.getRightTree());
        }

        return output;

    }

    /**
     * Interne Übungsmethode zur Traversierung.
     * @param tree Der zu traversierende Binärbaum.
     * @return Die Anzahl der Knoten in diesem Baum
     */
    private int countNodes(BinaryTree tree){
        //TODO 05: Übungsmethode
	return 0;
    }
}
