package sai.norms.npl.nopl2sai;

import sai.main.institution.INormativeEngine;

public interface INormativeBoard2SaiListener {
	public void test();
	public void sai_committed(String agent, String mission, String scheme);
	public INormativeEngine getNormEngine();

}
