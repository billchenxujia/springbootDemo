package effectiveJava.chapter4.item22;

import static effectiveJava.chapter4.item22.PhysicalConstants.*;

public class Test { 
    double atoms(double mols) { 
        return AVOGADROS_NUMBER * mols; 
    }    
    // PhysicalConstants更多的使用证明静态导入是正当的
}
