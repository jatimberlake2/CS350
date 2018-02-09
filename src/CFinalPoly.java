class A {
	public void f() { System.out.printf(" f of A\n"); }
	public void g() { System.out.printf(" g of A\n"); }
	public void h() { System.out.printf(" h of A\n"); }
}
class B extends A {
	public void f() { System.out.printf(" f of B\n"); }
}
class C extends B {
	public void g() { System.out.printf(" g of C\n"); }
}
class D extends C {
	public void h() { System.out.printf(" h of D\n"); }
}
abstract class P {
	public abstract void u();
	public void v() { System.out.printf(" v of P\n"); }
}
class Q extends P {
	public void u() { System.out.printf(" u of Q\n"); }
}
class R extends P {
	public void u() { System.out.printf(" u of R\n"); }
	public void v() { System.out.printf(" v of R\n"); }
}
public class CFinalPoly {
    public static void main( String[] args ) {
        A a = new A();	B b = new B();
        C c = new C();	D d = new D();
        P p = null; Q q = new Q();	R r = new R();     
        a.f();	// what is printed?
        a.g();	// what is printed?
        a.h();	// what is printed?
        b.f();	// what is printed?
        b.g();	// what is printed?
        b.h();	// what is printed?
        c.f();	// what is printed?
        c.g();	// what is printed?
        c.h();	// what is printed?
        d.f();	// what is printed?
        d.g();	// what is printed?
        d.h();	// what is printed?
        q.u();	// what is printed?
        q.v();	// what is printed?
        r.u();	// what is printed?
        r.v();	// what is printed?
        p=q;
        p.u();	// what is printed?
        p.v();	// what is printed?
        p=r;
        p.u();	// what is printed?
        p.v();	// what is printed?    
    }
}
