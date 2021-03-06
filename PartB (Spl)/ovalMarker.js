/*
	This code is to add oval markers for end-to-end connections.
*/

mxGraphGetCellStyle = mxGraph.prototype.getCellStyle;

mxGraph.prototype.getCellStyle = function(cell)
{
	var style = mxGraphGetCellStyle.apply(this, arguments);
	
	if (style != null && this.model.isEdge(cell))
	{
		style = mxUtils.clone(style);
		
		if (this.model.isEdge(this.model.getTerminal(cell, true)))
		{
			style['startArrow'] = 'oval';
		}

		if (this.model.isEdge(this.model.getTerminal(cell, false)))
		{
			style['endArrow'] = 'oval';
		}
	}
	
	return style;
};