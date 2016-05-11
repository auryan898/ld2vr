// $Id: Matrix3.java 1.8 1999/10/10 21:05:28 parisjp Exp $

//		 This file is part of LD2VR
//		Author: Paris.Jean-Pierre@wanadoo.fr
//
// LD2VR is free software; you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation; either version 2, or (at your option)
// any later version.
//
// LD2VR is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.
//
// You should have received a copy of the GNU General Public License
// along with for example GNU Emacs; see the file COPYING.  If not,
// write to the Free Software Foundation, 675 Mass Ave, Cambridge, MA
// 02139, USA.

package TOOLS;

import java.lang.StringBuffer;

import VRML2.Transform;

/** A general 3x3 matrix class. It implements classical operations on
 * matrices. For example: invertion, multiplication... It also offers
 * several static methods that returns 3D rotation matrices from
 * axis/angle.
 *
 * @author <a href="mailto:paris.Jean-Pierre@wanadoo.fr">Jean-Pierre Paris</a>
 * @see    TOOLS.Vector3
 * @see    TOOLS.Point3
 */
public class Matrix3 {
   /** Default constructor initializes the matrix with <code>0.0</code>.
    */
   public Matrix3() {
      m11_ = 0.0; m12_ = 0.0; m13_ = 0.0;
      m21_ = 0.0; m22_ = 0.0; m23_ = 0.0;
      m31_ = 0.0; m32_ = 0.0; m33_ = 0.0;
   }
   
   /** Builds up a <code>Matrix3</code> from 9 <code>double</code>
    * values. First three values represent the first line. The six
    * last values set the two remaning lines accordingly.
    *
    * @param  mij  9 matrix cells.  */
   public Matrix3(double m11, double m12, double m13,
                  double m21, double m22, double m23,
                  double m31, double m32, double m33) {
      m11_ = m11; m12_ = m12; m13_ = m13;
      m21_ = m21; m22_ = m22; m23_ = m23;
      m31_ = m31; m32_ = m32; m33_ = m33;
   }

   /** Builds up a <code>Matrix3</code> from three 3D vectors. First
    * vector represents the first line.
    *
    * @param  v1   first matrix line
    * @param  v2   second matrix line
    * @param  v3   third matrix line
    */
   public Matrix3(Vector3 v1, Vector3 v2, Vector3 v3) {
      m11_ = v1.x; m12_ = v1.y; m13_ = v1.z;
      m21_ = v2.x; m22_ = v2.y; m23_ = v2.z;
      m31_ = v3.x; m32_ = v3.y; m33_ = v3.z;
      //m11_ = v1.x; m12_ = v2.x; m13_ = v3.x;
      //m21_ = v1.y; m22_ = v2.y; m23_ = v3.y;
      //m31_ = v1.z; m32_ = v2.z; m33_ = v3.z;
   }

   /** Copy contructor.
    *
    * @param  m   the <code>Matrix3</code> that is copied
    */
   public Matrix3(Matrix3 m) {
      m11_ = m.m11_; m12_ = m.m12_; m13_ = m.m13_;
      m21_ = m.m21_; m22_ = m.m22_; m23_ = m.m23_;
      m31_ = m.m31_; m32_ = m.m32_; m33_ = m.m33_;
   }

   /** Copies its argument into an already existing <code>Matrix3</code>.
    *
    * @param  m   the <code>Matrix3</code> that is copied
    */
   public void copy(Matrix3 m) {
      m11_ = m.m11_; m12_ = m.m12_; m13_ = m.m13_;
      m21_ = m.m21_; m22_ = m.m22_; m23_ = m.m23_;
      m31_ = m.m31_; m32_ = m.m32_; m33_ = m.m33_;
   }

   /** Returns the <code>Matrix3</code> determinant
    *
    * @return   the determinant as <code>double</code>
    */
   public double det() {
      double d11 = m22_ * m33_ - m32_ * m23_;
      double d21 = -(m21_ * m33_ - m31_ * m23_);
      double d31 = m21_ * m32_ - m31_ * m22_;
      
      return m11_ * d11 + m12_ * d21 + m13_ * d31;
   }
   
   /** Returns a rotational matrix about the X axis.
    *
    * @param   angle   the rotation angle about the X axis
    * @return  a <code>Matrix3</code> representing a rotation matrix
    * @see     Matrix3#Ry(double)
    * @see     Matrix3#Rz(double)
    * @see     Matrix3#Rot(double, double, double, double)
    */
   public static final Matrix3 Rx(double angle) {
      return new Matrix3(1, 0,           0,
                         0, Math.cos(angle), -Math.sin(angle),
                         0, Math.sin(angle), Math.cos(angle));
   }

   /** Returns a rotational matrix about the Y axis.
    *
    * @param   angle   the rotation angle about the Y axis
    * @return  a <code>Matrix3</code> representing a rotation matrix
    * @see     Matrix3#Rx(double)
    * @see     Matrix3#Rz(double)
    * @see     Matrix3#Rot(double, double, double, double)
    */
   public static final Matrix3 Ry(double angle) {
      return new Matrix3(Math.cos(angle),  0, Math.sin(angle),
                         0,            1, 0,
                         -Math.sin(angle), 0, Math.cos(angle));
   }

   /** Returns a rotational matrix about the Z axis.
    *
    * @param   angle   the rotation angle about the Z axis
    * @return  a <code>Matrix3</code> representing a rotation matrix
    * @see     Matrix3#Rx(double)
    * @see     Matrix3#Ry(double)
    * @see     Matrix3#Rot(double, double, double, double)
    */
   public static final Matrix3 Rz(double angle) {
      return new Matrix3(Math.cos(angle), -Math.sin(angle), 0,
                         Math.sin(angle), Math.cos(angle), 0,
                         0,           0,           1);
   }

   /** Returns a rotational matrix about an axis.
    *
    * @param   angle   the rotation angle about the Z axis
    * @return  a <code>Matrix3</code> representing a rotation matrix
    * @see     Matrix3#Rx(double)
    * @see     Matrix3#Ry(double)
    * @see     Matrix3#Rz(double)
    */
   public static final Matrix3 rotation(double x, double y, double z,
                                        double angle) {
      double c = Math.cos(angle);
      double s = Math.sin(angle);
      double t = 1 - c;
      return new Matrix3(t*x*x + c,   t*x*y - s*z, t*x*z + s*y,
                         t*y*x + s*z, t*y*y + c,   t*y*z - s*x,
                         t*z*x - s*y, t*z*y + s*x, t*z*z + c);
   }

   /** Returns a matrix that changes to another orthogonal normalized
    * coordinate system. The new system is represented by the 3 vectors that
    * must be orthogonal. Vectors should not be normalized.
    *
    * @param   vx  the new X-axis vector
    * @param   vy  the new Y-axis vector
    * @param   vz  the new Z-axis vector
    * @return  the transformation <code>Matrix3</code>
    */
   public static final Matrix3 getNewBase(Vector3 vx, Vector3 vy, Vector3 vz) {
      Vector3 vxn = vx.normalize();
      Vector3 vyn = vy.normalize();
      Vector3 vzn = vz.normalize();
      return new Matrix3(vxn.x, vyn.x, vzn.x,
                         vxn.y, vyn.y, vzn.y,
                         vxn.z, vyn.z, vzn.z);
   }
   /** Stores a commonly used symetry matrix
    */
   static Matrix3 symX_ = new Matrix3(-1, 0, 0, 0, 1, 0, 0, 0, 1);
   
   /** Returns a matrix representing the symetry about the YZ plane.
    *
    * @return  the transformation <code>Matrix3</code>
    */
   public static final Matrix3 symX() {
      return symX_;
   }

   /** Stores a commonly used matrix: identity
    */
   static Matrix3 id_ = new Matrix3(1, 0, 0, 0, 1, 0, 0, 0, 1);

   /** Returns a matrix representing the identity.
    *
    * @return  the transformation <code>Matrix3</code>
    */
   public static final Matrix3 id() {
      return id_;
   }

   /** Returns a matrix that represents a symetry about a plane. The
    * plane is given by a normal vector. If the vector is
    * <code>null</code>, return the identity matrix.
    *
    * @param   v  the plane normal vector.
    * @return  the transformation <code>Matrix3</code> */
   public static Matrix3 symetry(Vector3 v) {
      if (null == v) {
         return id_;
      }
      Vector3 vI = v;
      Vector3 vJ;
      if (vI.eps_eqI()) {
         // If vI is X-aligned, vJ is Y-aligned
         vJ = new Vector3(0, 0, 1).crossMult(vI);
      } else {
         // Otherwise, vJ is normal to X and vI
         vJ = vI.crossMult(new Vector3(1, 0, 0));
      }
      Vector3 vK = vI.crossMult(vJ);

      Matrix3 base = getNewBase(vI, vJ, vK);
      return base.mult(symX_.mult(base.invert()));
   }

   /** Extracts VRML97 transformations (rotation, scale) from a matrix.
    * Extracted transformations are stored in a VRML97 Transform node
    * given as argument. Remaining transformations are returned as
    * a <code>Matrix3</code>.
    *
    * @param   t  the VRML97 Transform node
    * @return  the remaning transformation
    */
   public Matrix3 toVRML2(Transform t) {
      Vector3 line1 = getLine1();
      Vector3 line2 = getLine2();
      Vector3 line3 = getLine3();
      double scaleX = line1.length();
      double scaleY = line2.length();
      double scaleZ = line3.length();
      double det = det();

      // Scale is really simple to extract.
      if (!T.eps_equals(scaleX, 1) ||
          !T.eps_equals(scaleY, 1) ||
          !T.eps_equals(scaleZ, 1)) {
         t.set_scale(Math.max(scaleX, 1e-4),   // 0 is an illegal scale
                     Math.max(scaleY, 1e-4),   // but beware of rounded
                     Math.max(scaleZ, 1e-4));  // numbers
      }

      if (T.eps_zero(det)) {
         // Special cases

         if (T.eps_zero(scaleX)) {
            return new Matrix3(line1,
                               line2.normalize(),
                               line3.normalize());
         } else if (T.eps_zero(scaleY)) {
            return new Matrix3(line1.normalize(),
                               line2,
                               line3.normalize());
         } else if (T.eps_zero(scaleZ)) {
            return new Matrix3(line1.normalize(),
                               line2.normalize(),
                               line3);
         } else {
            return new Matrix3(line1.normalize(),
                               line2.normalize(),
                               line3.normalize());
         }
      } else if (T.eps_equals(Math.abs(det), 1)) {
         // OK extract rotation.
         
         // Simple matrix modification. WARNING: no change to 'det'
         if (det < 0) {
            m11_ = - m11_;
            m12_ = - m12_;
            m13_ = - m13_;
         }

         double vdX = 0;
         double vdY = 0;
         double vdZ = 0;
         double angle = 0;

         if (T.eps_equals(m11_ + m22_ + m33_, 3)) {
            // Three '1' on the diagonal
            if (det < 0) {
               // YES, it's possible: look at the matrix modification
               // above.
               return symX();
            } else {
               return id();
            }
         } else if (T.eps_equals(m11_ + m22_ + m33_, -1)) {
            // One '1' and two '-1': symetry about an axis or PI
            // rotation about this axis.
            angle = Math.PI;

            vdX = Math.sqrt((m11_ + 1) / 2);
            vdY = 0;
            vdZ = 0;
            if (0 == vdX) {
               vdY = Math.sqrt((m22_ + 1) / 2);
               if (0 == vdY) {
                  vdZ = Math.sqrt((m33_ + 1) / 2);
               } else {
                  vdZ = m32_ / (2 * vdY);
               }
            } else {
               vdY = m21_ / (2 * vdX);
               vdZ = m31_ / (2 * vdX);
            }
         } else {
            // General rotation matrix
            double cosA = (m11_ + m22_ + m33_ - 1) / 2;
            angle = Math.acos(cosA);
            double sinA_2 = 2* Math.sin(angle);

            vdX = (m32_ - m23_) / sinA_2;
            vdY = (m13_ - m31_) / sinA_2;
            vdZ = (m21_ - m12_) / sinA_2;
         }

         if (! checkMatrix(vdX, vdY, vdZ, angle)) {
            // Shear matrix!
            Matrix3 norm =  new Matrix3(line1.normalize(),
                                        line2.normalize(),
                                        line3.normalize());
            System.err.println("Warning: shear matrix. Not optimized.");
            return norm;
         }

         t.set_rotation(vdX, vdY, vdZ, angle);
         // Because of VRML transformation order
         t.set_scaleOrientation(vdX, vdY, vdZ, -angle);

         if (det < 0) {
            // Compute the remaing tranformation:
            // it is an YZ-symetry in the rotated coordinate system.
            Matrix3 rot = Matrix3.rotation(vdX, vdY, vdZ, angle);
            return rot.invert().mult(Matrix3.symX().mult(rot));
         } else {
            // All the transformations are translated to VRML. 
            return id();
         }
      } else {
         // Normalize lines
         Matrix3 norm =  new Matrix3(line1.normalize(),
                                     line2.normalize(),
                                     line3.normalize());
         double normDet = norm.det();

         if (T.eps_equals(Math.abs(normDet), 1)) {
            // and call toVRML2 again if det is +-1
            return norm.toVRML2(t);
         } else {
            // Otherwise, return the normalized matrix
            System.err.println("Warning: matrix det != +-1. Not optimized.");
            return norm;
         }
      }
   }

   /** Tests matrix equality.
    *
    * @param   o  the object to be compared to.
    * @return  a <code>boolean</code> value
    */
   public boolean equals(Object o) {
      try {
         Matrix3 m = (Matrix3)o;
         return ((m11_ == m.m11_) && (m12_ == m.m12_) && (m13_ == m.m13_) &&
                 (m21_ == m.m21_) && (m22_ == m.m22_) && (m23_ == m.m23_) &&
                 (m31_ == m.m31_) && (m32_ == m.m32_) && (m33_ == m.m33_));
      } catch (ClassCastException e) {
         return false;
      }
   }

   /** Tests matrix equality with tolerance.
    *
    * @param   m  the object to be compared to.
    * @return  a <code>boolean</code> value
    * @see     T#eps_equals(double, double)
    */
   public boolean eps_equals(Matrix3 m) {
      return (T.eps_equals(m11_, m.m11_) && T.eps_equals(m12_, m.m12_)
              && T.eps_equals(m13_, m.m13_) &&
              T.eps_equals(m21_, m.m21_) && T.eps_equals(m22_, m.m22_)
              && T.eps_equals(m23_, m.m23_) &&
              T.eps_equals(m31_, m.m31_) && T.eps_equals(m32_, m.m32_)
              && T.eps_equals(m33_, m.m33_));
   }

   /** Tests matrix identity with tolerance.
    *
    * @return  a <code>boolean</code> value
    * @see     T#eps_equals(double, double)
    */
   public boolean eps_Id() {
      return (T.eps_equals(m11_, 1) && T.eps_equals(m12_, 0)
              && T.eps_equals(m13_, 0) &&
              T.eps_equals(m21_, 0) && T.eps_equals(m22_, 1)
              && T.eps_equals(m23_, 0) &&
              T.eps_equals(m31_, 0) && T.eps_equals(m32_, 0)
              && T.eps_equals(m33_, 1));
   }

   /** Adds 2 matrix without side-effect.
    *
    * @param    m  the added matrix
    * @return   a newly constructed matrix
    */
   public Matrix3 add(Matrix3 m) {
      return new Matrix3(m11_ + m.m11_, m12_ + m.m12_, m13_ + m.m13_,
                         m21_ + m.m21_, m22_ + m.m22_, m23_ + m.m23_,
                         m31_ + m.m31_, m32_ + m.m32_, m33_ + m.m33_);
   }

   /** Substracts a matrix to another without side-effect.
    *
    * @param    m  the substracted matrix
    * @return   a newly constructed matrix
    */
   public Matrix3 sub(Matrix3 m) {
      return new Matrix3(m11_ - m.m11_, m12_ - m.m12_, m13_ - m.m13_,
                         m21_ - m.m21_, m22_ - m.m22_, m23_ - m.m23_,
                         m31_ - m.m31_, m32_ - m.m32_, m33_ - m.m33_);
   }

   /** Divides a matrix with a scalar. All nine values are divided by
    * the scalar.
    *
    * @param    d  the scalar
    * @return   a newly constructed matrix
    */
   public Matrix3 div(double d) {
      return new Matrix3(m11_ / d, m12_ / d, m13_ / d,
                         m21_ / d, m22_ / d, m23_ / d,
                         m31_ / d, m32_ / d, m33_ / d);
   }
   
   /** Multiplies 2 matrix without side-effect. I think it's right
    * multiplication. If somebody can confirm that...
    *
    * @param    m  the multiplied matrix
    * @return   a newly constructed matrix
    */
   public Matrix3 mult(Matrix3 m) {
      Matrix3 r = new Matrix3();
      
      r.m11_ = m11_ * m.m11_ + m12_ * m.m21_ + m13_ * m.m31_;
      r.m12_ = m11_ * m.m12_ + m12_ * m.m22_ + m13_ * m.m32_;
      r.m13_ = m11_ * m.m13_ + m12_ * m.m23_ + m13_ * m.m33_;
      
      r.m21_ = m21_ * m.m11_ + m22_ * m.m21_ + m23_ * m.m31_;
      r.m22_ = m21_ * m.m12_ + m22_ * m.m22_ + m23_ * m.m32_;
      r.m23_ = m21_ * m.m13_ + m22_ * m.m23_ + m23_ * m.m33_;
      
      r.m31_ = m31_ * m.m11_ + m32_ * m.m21_ + m33_ * m.m31_;
      r.m32_ = m31_ * m.m12_ + m32_ * m.m22_ + m33_ * m.m32_;
      r.m33_ = m31_ * m.m13_ + m32_ * m.m23_ + m33_ * m.m33_;

      return r;
   }

   /** Multiplies a vector by a matrix.
    *
    * @param    v  the multiplied vector
    * @return   a newly constructed vector
    */
   public Vector3 mult(Vector3 v) {
      return new Vector3(m11_ * v.x + m12_ * v.y + m13_ * v.z,
                         m21_ * v.x + m22_ * v.y + m23_ * v.z,
                         m31_ * v.x + m32_ * v.y + m33_ * v.z);
   }
   /** Multiplies a point by a matrix.
    *
    * @param    v  the multiplied point
    * @return   a newly constructed vector
    */
   public Point3 mult(Point3 v) {
      return new Point3(m11_ * v.x + m12_ * v.y + m13_ * v.z,
                        m21_ * v.x + m22_ * v.y + m23_ * v.z,
                        m31_ * v.x + m32_ * v.y + m33_ * v.z);
   }

   /** Multiplies a point by a matrix.
    *
    * @param    v       the multiplied point
    * @param    result  the resulting point with side-effect
    */
   public void mult(Point3 v, Point3 result) {
      result.x = m11_ * v.x + m12_ * v.y + m13_ * v.z;
      result.y = m21_ * v.x + m22_ * v.y + m23_ * v.z;
      result.z = m31_ * v.x + m32_ * v.y + m33_ * v.z;
   };

   /** Inverts a matrix without side-effect.
    *
    * @return     a newly constructed matrix
    * @exception  InvertException
    *               if determinant equals 0 with tolerance
    * @see        T#eps_equals(double, double)
    */
   public Matrix3 invert() throws InvertException {
      Matrix3 r = new Matrix3();

      r.m11_ = m22_ * m33_ - m32_ * m23_;
      r.m21_ = -(m21_ * m33_ - m31_ * m23_);
      r.m31_ = m21_ * m32_ - m31_ * m22_;
      
      double det = m11_ * r.m11_ + m12_ * r.m21_ + m13_ * r.m31_;
      
      if (T.eps_equals(0, det)) {
         throw new InvertException();
      } else {
         r.m12_ = -(m12_ * m33_ - m32_ * m13_);
         r.m13_ = m12_ * m23_ - m22_ * m13_;
         r.m22_ = m11_ * m33_ - m31_ * m13_;
         r.m23_ = - (m11_ * m23_ - m21_ * m13_);
         r.m32_ = - (m11_ * m32_ - m31_ * m12_);
         r.m33_ = m11_ * m22_ - m21_ * m12_;
         return r.div(det);
      }
   }

   /** Returns the symetric matrix.
    *
    * @return     a newly constructed matrix
    */
   public Matrix3 symetrise() {
      return new Matrix3(m11_, m21_, m31_,
                         m12_, m22_, m32_,
                         m13_, m23_, m33_);
   }

   /** Returns a String representation of this <code>Matrix3</code>
    * object. Lines are separated with newline, values with
    * tabulation.
    *
    * @return  a String
    * @see     #concat()
    */
   public String toString() {
      return 
         m11_ + "	" + m12_ + "	" + m13_ + "\n" +
         m21_ + "	" + m22_ + "	" + m23_ + "\n" +
         m31_ + "	" + m32_ + "	" + m33_;
   }
   /** Returns a String representation of this <code>Matrix3</code>
    * object. All values are rounded, then packed together in a String.
    * Finally, '.' are replaced by '_'.
    *
    * @return  a String
    * @see     #toString()
    */
   public String concat() {
      if (eps_equals(id_)) {
         return "";
      }
      String s = null;
      // Some crappy code to reduce result length!
      if (T.eps_equals(1, m33_)) {
         if (T.eps_equals(0, m32_)) {
            if (T.eps_equals(0, m31_)) {
               if (T.eps_equals(0, m23_)) {
                  if (T.eps_equals(1, m22_)) {
                     if (T.eps_equals(0, m21_)) {
                        if (T.eps_equals(0, m13_)) {
                           if (T.eps_equals(0, m12_)) {
                              if (T.eps_equals(-1, m11_)) {
                                 return "-";
                              } else {
                                 s = T.rounds(m11_, 1e3);
                              }
                           } else {
                              s = T.rounds(m11_, 1e3) + "" + T.rounds(m12_, 1e3);
                           }
                        } else {
                           s = T.rounds(m11_, 1e3) + "" + T.rounds(m12_, 1e3) + "" +
                              T.rounds(m13_, 1e3);
                        }
                     } else {
                        s = T.rounds(m11_, 1e3) + "" + T.rounds(m12_, 1e3) + "" +
                           T.rounds(m13_, 1e3) + "" + T.rounds(m21_, 1e3);
                     }
                  } else {
                     s = T.rounds(m11_, 1e3) + "" + T.rounds(m12_, 1e3) + "" +
                        T.rounds(m13_, 1e3) + "" + T.rounds(m21_, 1e3) + "" +
                        T.rounds(m22_, 1e3);
                  }
               } else {
                  s = T.rounds(m11_, 1e3) + "" + T.rounds(m12_, 1e3) + "" +
                     T.rounds(m13_, 1e3) + "" + T.rounds(m21_, 1e3) + "" +
                     T.rounds(m22_, 1e3) + "" + T.rounds(m23_, 1e3);
               }
            } else {
               s = T.rounds(m11_, 1e3) + "" + T.rounds(m12_, 1e3) + "" +
                  T.rounds(m13_, 1e3) + "" + T.rounds(m21_, 1e3) + "" +
                  T.rounds(m22_, 1e3) + "" + T.rounds(m23_, 1e3) + "" +
                  T.rounds(m31_, 1e3);
            }
         } else {
            s = T.rounds(m11_, 1e3) + "" + T.rounds(m12_, 1e3) + "" +
               T.rounds(m13_, 1e3) + "" + T.rounds(m21_, 1e3) + "" +
               T.rounds(m22_, 1e3) + "" + T.rounds(m23_, 1e3) + "" +
               T.rounds(m31_, 1e3) + "" + T.rounds(m32_, 1e3);
         }
      } else {
         s = T.rounds(m11_, 1e3) + "" + T.rounds(m12_, 1e3) + "" + T.rounds(m13_, 1e3) + "" +
            T.rounds(m21_, 1e3) + "" + T.rounds(m22_, 1e3) + "" + T.rounds(m23_, 1e3) + "" +
            T.rounds(m31_, 1e3) + "" + T.rounds(m32_, 1e3) + "" + T.rounds(m33_, 1e3);
      }
      StringBuffer result = new StringBuffer(s);

      int index = 0;
      while (-1 != (index = s.indexOf('.', index))) {
         result.setCharAt(index, '_');
         index++;
      }
      return result.toString();
   }
   
   /** For testing purpose.
    */
   static public void main(String[] args) {
      //testSymetry();
      testDecomp();
   }

   double m11_, m12_, m13_;
   double m21_, m22_, m23_;
   double m31_, m32_, m33_;

   /** Returns the first line of the matrix.
    *
    * @return  a vector representing the first line.
    * @see     Matrix3#getLine2()
    * @see     Matrix3#getLine3() */
   private Vector3 getLine1() {
      return new Vector3(m11_, m12_, m13_);
   }
   /** Returns the second line of the matrix.
    *
    * @return  a vector representing the second line.
    * @see     Matrix3#getLine1()
    * @see     Matrix3#getLine3()
    */
   private Vector3 getLine2() {
      return new Vector3(m21_, m22_, m23_);
   }
   /** Returns the third line of the matrix.
    *
    * @return  a vector representing the third line.
    * @see     Matrix3#getLine1()
    * @see     Matrix3#getLine2()
    */
   private Vector3 getLine3() {
      return new Vector3(m31_, m32_, m33_);
   }

   /** Returns true if the matrix represents an axis/angle rotation.
    *
    * @param  x      axis' x-coordinate
    * @param  y      axis' y-coordinate
    * @param  z      axis' z-coordinate
    * @param  angle  the rotation angle
    * @return a boolean
    * @see           #toVRML2(Transform)
    */
   private boolean checkMatrix(double x, double y, double z, double angle) {
      double c = Math.cos(angle);
      double s = Math.sin(angle);
      double t = 1 - c;

      return (T.eps_equals(m11_, t*x*x + c, 10e-3) &&
              T.eps_equals(m21_, t*x*y + s*z, 10e-3) &&
              T.eps_equals(m31_, t*x*z - s*y, 10e-3) &&
              T.eps_equals(m12_, t*y*x - s*z, 10e-3) &&
              T.eps_equals(m22_, t*y*y + c, 10e-3) &&
              T.eps_equals(m32_, t*y*z + s*x, 10e-3) &&
              T.eps_equals(m13_, t*z*x + s*y, 10e-3) &&
              T.eps_equals(m23_, t*z*y - s*x, 10e-3) &&
              T.eps_equals(m33_, t*z*z + c, 10e-3));
   };

   /** For testing purpose.
    */
   private static void test1() {
      Matrix3 m1 = new Matrix3(1, 2, 3,
                               4, 5, 6,
                               7, 8, 1);
      //Matrix3.testInvert(m1);
      //Matrix3.testInvert(new Matrix3(1, 0, 0, 0, 1, 1, 0, 1, 2));
      //Matrix3.testInvert(new Matrix3(1, 3, 3, 3, 2, 3, 3, 3, 3));
      
      Vector3 v1 = new Vector3(1, 1, 0);
      Vector3 v1_x = Matrix3.Rx(Math.PI / 2).mult(v1);
      Vector3 v1_y = Matrix3.Ry(- Math.PI / 4).mult(v1);
      Vector3 v1_z = Matrix3.Rz(Math.PI / 4).mult(v1);
      System.out.println("----------\n" + v1_x +
                         "\n" + v1_y +
                         "\n" + v1_z);

      Matrix3 rr = (Matrix3.Ry(-0.7853981633974483)
                    .mult(Matrix3.Rx(0.9553166181245092)))
         .sub(Matrix3.id());
      Matrix3.testInvert(rr);
   }
   /** For testing purpose.
    */
   private static void testSymetry() {
      Matrix3 m1 = symetry(new Vector3(1, 0, 0));
      System.out.println(m1 + "\n----------");
      Matrix3 m2 = symetry(new Vector3(0, 1, 0));
      System.out.println(m2 + "\n----------");
      Matrix3 m3 = symetry(new Vector3(0, 0, 1));
      System.out.println(m3 + "\n----------");
      Matrix3 m4 = symetry(new Vector3(1, 1, 0));
      System.out.println(m4 + "\n----------");
   }
   /** For testing purpose.
    */
   private static void testInvert(Matrix3 m) {
      System.out.println("----------\n" + m);
      Matrix3 m_1 = m.invert();
      System.out.println("\n" + m_1);
      System.out.println("\n" + m.mult(m_1));
      System.out.println("\n" + m_1.mult(m));
   }
   /** For testing purpose.
    */
   private static void testDecomp() {
      Matrix3 m1 = Matrix3.Rz(Math.PI/2);
      Matrix3 m2 = Matrix3.symX();

      Vector3 v1 = new Vector3(1, 0, 0);
      //System.out.println(m1.symetrise().mult(v1));
      System.out.println(m1.mult(m2).mult(v1));
   }
}
